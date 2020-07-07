package com.tda.test;

import static org.junit.Assert.assertEquals;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import com.tda.ejb.CalculatorBean;
import com.tda.ejb.CounterBean;

public class Test_ {
	private static EJBContainer contenedor;
	private static Context contexto;
	private static CalculatorBean calculatorEjb;
	private static CounterBean counterEjb;

	public static void main(String[] args) throws NamingException {
		System.out.println("Iniciando Contenedor");
		contenedor = EJBContainer.createEJBContainer();
		contexto = contenedor.getContext();
		calculatorEjb = (CalculatorBean) contexto.lookup("java:global/LocalRemoteEJBServer/CalculatorBean!com.tda.ejb.RemoteCalculator");
		String text = calculatorEjb.version();
		//assertEquals("1.0.0.1", text);
		System.out.println("Versión = "+text);
		counterEjb = (CounterBean) contexto.lookup("java:global/LocalRemoteEJBServer/CounterBean!com.tda.ejb.RemoteCounter");
		System.out.println("Counter ="+counterEjb.getCount());
		counterEjb.increment();
		System.out.println("Counter ="+counterEjb.getCount());
	}

}
