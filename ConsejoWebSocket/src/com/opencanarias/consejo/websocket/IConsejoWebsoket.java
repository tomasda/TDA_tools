package com.opencanarias.consejo.websocket;

import java.io.IOException;

import javax.websocket.EncodeException;

public interface IConsejoWebsoket {

	public void broadcast(Object message) throws IOException, EncodeException;
}
