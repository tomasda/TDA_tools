/**
 * 
 */
package com.tda.test;

import static org.junit.Assert.*;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import org.junit.BeforeClass;


/**
 * @author Admin-AE
 *
 */
public class Test {
	private static EJBContainer contenedor;
	private static Context contexto;
//	private static Hola ejb;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Iniciando Contenedor");
		contenedor = EJBContainer.createEJBContainer();
		contexto = contenedor.getContext();
	//	ejb = (Hola) contexto.lookup("java:global/LocalRemoteEJBServer/Hola!com.tda.ejb.Hola");
	}

	@org.junit.Test
	public void test() {
//		String text = ejb.version();
//		assertEquals("1.0.0.1", text);
//		System.out.println("Versión = "+text);
	}

}
