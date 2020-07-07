/**
 * 
 */
package com.main.core;

import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;

//import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.websocket.EncodeException;

import com.opencanarias.consejo.websocket.ConsejoWebSocketRemote;
import com.opencanarias.consejo.websocket.IConsejoWebsoket;
import com.tda.ejb.CalculatorInterface;
import com.tda.ejb.CoreInterface;
import com.tda.ejb.CounterInterface;


/**
 * @author Tomas
 *
 */

public class Core implements Serializable {


	private static final long serialVersionUID = 1L;
	private String version = "152447";
	private int count;
	private int calcA;
	private int calcB;

	
	private CoreInterface ejbCore;
	 
	private CounterInterface ejbCounter;
	 
	private CalculatorInterface ejbCalculator;
	
	private ConsejoWebSocketRemote ejbConsejo;


	public Core (){
		this.calcA = 0;
		this.calcB = 0;
		constructor();
	}

	/**
	 * EJB´s
	 * 
	 * java:global/LocalRemoteEJBServer/CoreBean!com.tda.ejb.CoreInterface
	 * java:global/LocalRemoteEJBServer/CounterBean!com.tda.ejb.CounterInterface
	 * java:global/LocalRemoteEJBServer/CalculatorBean!com.tda.ejb.CalculatorInterface
	 */

	/**
	 * Métodos.
	 */
	private void constructor() {
		Properties jndiProperties = new Properties();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		Context ctx;
		try {
			ctx = new InitialContext(jndiProperties);
			
			String lookup =  //"java:global/FacadeEAR/FacadeOneEJB/CoreBean!com.tda.ejb.CoreInterface";
							"java:global/LocalRemoteEJBServer/CoreBean!com.tda.ejb.CoreInterface";
			ejbCore = (CoreInterface) ctx.lookup(lookup);
			version = ejbCore.version();

			lookup = //"java:global/FacadeEAR/FacadeOneEJB/CounterBean!com.tda.ejb.CounterInterface";
					"java:global/LocalRemoteEJBServer/CounterBean!com.tda.ejb.CounterInterface";
			ejbCounter = (CounterInterface) ctx.lookup(lookup);
			count = ejbCounter.getCount();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}


	private void getEJBCount(){
		Properties jndiProperties = new Properties();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		Context ctx;
		try {
			ctx = new InitialContext(jndiProperties);


			String lookup =  //"java:global/FacadeEAR/FacadeOneEJB/CounterBean!com.tda.ejb.CounterInterface";
							"java:global/LocalRemoteEJBServer/CounterBean!com.tda.ejb.CounterInterface";
			ejbCounter = (CounterInterface) ctx.lookup(lookup);
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ejbCounter.increment();
		count = ejbCounter.getCount();
	}
	
	public int getEJBCalculator() {
		Properties jndiProperties = new Properties();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		Context ctx;
		try {
			ctx = new InitialContext(jndiProperties);


			String lookup = //"java:global/FacadeEAR/FacadeOneEJB/CalculatorBean!com.tda.ejb.CalculatorInterface";
					"java:global/LocalRemoteEJBServer/CalculatorBean!com.tda.ejb.CalculatorInterface";
			ejbCalculator = (CalculatorInterface) ctx.lookup(lookup);
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ejbCalculator.add(this.calcA, this.calcB);
	}


	/**
	 * Ejecutores.
	 */
	public void countAdd() {
		getEJBCount();
	}
	public void calcAdd() {
		
	}
	
	public void SocketCall() {
		Properties jndiProperties = new Properties();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		Context ctx;
		try {
			ctx = new InitialContext(jndiProperties);
			/*
			 * 
			  					
				java:global/ConsejoWebSocket/ConsejoEndPoint!com.opencanarias.consejo.websocket.ConsejoWebSocketRemote
				java:app/ConsejoWebSocket/ConsejoEndPoint!com.opencanarias.consejo.websocket.ConsejoWebSocketRemote
				java:module/ConsejoEndPoint!com.opencanarias.consejo.websocket.ConsejoWebSocketRemote
				java:jboss/exported/ConsejoWebSocket/ConsejoEndPoint!com.opencanarias.consejo.websocket.ConsejoWebSocketRemote
				ejb:/ConsejoWebSocket/ConsejoEndPoint!com.opencanarias.consejo.websocket.ConsejoWebSocketRemote
				java:global/ConsejoWebSocket/ConsejoEndPoint!com.opencanarias.consejo.websocket.ConsejoWebSocketLocal
				java:app/ConsejoWebSocket/ConsejoEndPoint!com.opencanarias.consejo.websocket.ConsejoWebSocketLocal
				java:module/ConsejoEndPoint!com.opencanarias.consejo.websocket.ConsejoWebSocketLocal
				ejb:/ConsejoWebSocket/ConsejoEndPoint!com.opencanarias.consejo.websocket.ConsejoWebSocketLocal
				*/

			String lookup = "java:global/ConsejoWebSocket/ConsejoEndPoint!com.opencanarias.consejo.websocket.ConsejoWebSocketRemote";
			ejbConsejo = (ConsejoWebSocketRemote) ctx.lookup(lookup);
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ejbConsejo.broadcast("Test from EJB");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EncodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Getters and Setters
	 * @param version
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	public String getVersion(){
		Properties jndiProperties = new Properties();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		Context ctx;
		try {
			ctx = new InitialContext(jndiProperties);


			String lookup = //"java:global/FacadeEAR/FacadeOneEJB/CoreBean!com.tda.ejb.CoreInterface";
			 "java:global/LocalRemoteEJBServer/CoreBean!com.tda.ejb.CoreInterface";
			//"java:global/LocalRemoteEJBServer/HolaBean!com.tda.ejb.HolaRemoteInterface";

			ejbCore = (CoreInterface) ctx.lookup(lookup);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		version = ejbCore.version();
		return version;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCalcA() {
		return calcA;
	}

	public void setCalcA(int calcA) {
		this.calcA = calcA;
	}

	public int getCalcB() {
		return calcB;
	}

	public void setCalcB(int calcB) {
		this.calcB = calcB;
	}

}
