package com.opencanarias.consejo.websocket.model;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.Session;

public  class Sessions {

	public static Set<Session> sesiones = new CopyOnWriteArraySet<>();

	public static Set<Session> sesionesAEliminar = new CopyOnWriteArraySet<>();
	
}
