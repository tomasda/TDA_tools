package com.opencanarias.consejo.websocket;

import java.io.IOException;
import java.io.Serializable;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

import org.jboss.logging.Logger;

import com.opencanarias.consejo.websocket.model.Sessions;


@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@ServerEndpoint(value="/consejo")
public class ConsejoEndPoint implements ConsejoWebSocketRemote, ConsejoWebSocketLocal, Serializable {
	private Logger logger = Logger.getLogger(ConsejoEndPoint.class);
	private static final long serialVersionUID = 1L;


	@OnMessage
	public String consejo(String message) {
		logger.info("Recived: "+ message);
		return "Hello from the server!";
	}

	@OnOpen
	public void myOnOpen(Session session) {
		logger.info("an user has connected "+ session.getId());

		Sessions.sesiones.add(session);
		try {
			broadcast("Connected!" +session.getId());
		} catch (IOException e) {
			logger.error("Error al notificar al cliente del websocket con id: "+session.getId());
			Sessions.sesiones.remove(session);
		} catch (EncodeException e) {
			logger.error("Error al codificar el objeto para enviarlo a los clientes");
		}
	}

	@OnClose
	public void myOnClose(CloseReason reason, Session session) {
		logger.info("Se ha desconectado un usuario del socket " + session.getId());
		Sessions.sesiones.remove(session);
		try {
			broadcast("Disconected"+ session.getId());
		} catch (IOException e) {
			logger.error("Error al desconectar al cliente del websocket con id: "+session.getId());
		} catch (EncodeException e) {
			logger.error("Error al codificar el objeto para enviarlo a los clientes");
		}
	}

	@OnError
	public void error(Throwable t) {}

	@Override
	public  void broadcast(Object message) throws IOException, EncodeException {

		Sessions.sesionesAEliminar.forEach(sesionAEliminar -> {
			try {
				Sessions.sesiones.remove(sesionAEliminar);
			} catch (Exception e) {
				logger.error("No se ha podido eliminar el cliente de la lista, probablemente ya se haya eliminado");
			}
		});

		//despues de borrar limpiamos el array
		Sessions.sesionesAEliminar.clear();

		Sessions.sesiones.forEach(endpoint -> {
			synchronized (endpoint) {
				try {
					endpoint.getBasicRemote().sendObject(message);
				} catch (IOException e) {
					logger.error("Error al notificar al cliente del websocket con id: "+endpoint.getId());
					logger.error("Se eliminará al cliente de la lista en el próximo broadcast");

				} catch (EncodeException e) {
					logger.error("Error al codificar el objeto para enviarlo a los clientes");
				}
			}
		});
	}

	
}

