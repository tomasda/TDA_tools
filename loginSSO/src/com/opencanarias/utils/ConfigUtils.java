package com.opencanarias.utils;

import java.io.IOException;
import java.util.Properties;

import org.jboss.logging.Logger;

//import com.opencanarias.exceptions.GenericFacadeException;

/**
 * Clase de utilidades que facilita el acceso a la configuracion de la aplicacion.
 * 
 * @author Open Canarias S.L.
 */
public class ConfigUtils {
	private static Logger logger = Logger.getLogger(ConfigUtils.class);
	private static Properties configuration;
	private static String entorno;

	/**
	 * Este metodo devuelve el entorno con el que estamos trabajando.
	 * 
	 * @throws GenericFacadeException
	 * @see configuration.properties
	 */
	public static String getEntorno() {
		return entorno;
	}

	/**
	 * Este metodo carga el fichero de propiedades de configuracion y carga el entorno con el que trabajaremos.
	 * 
	 * @throws GenericFacadeException
	 */
	private static Properties getConfiguration() {
		try {
			if (configuration == null) {
				configuration = new Properties();
				configuration.load(ConfigUtils.class.getResourceAsStream("/facade_configuration.properties"));
				entorno = configuration.getProperty("entorno");
			}
			return configuration;
		} catch (IOException e) {
			logger.error("Error al acceder a la configuracion de la aplicacion." + e.getMessage(), e);
			return null;
		}
	}

	/**
	 * Recupera un parametro de configuracion del fichero de propiedades facade_configuration.properties
	 * 
	 * @param nombre Nombre del parametro a recuperar
	 * @return Valor del parametro de configuracion
	 * @throws GenericFacadeException
	 */
	public static String getParametro(String nombre) {
		String tmp = getConfiguration().getProperty(getEntorno() + "." + nombre, getConfiguration().getProperty(nombre));
		return (tmp != null) ? tmp.trim() : null;
	}

	/**
	 * Recupera un parametro de configuracion del fichero de propiedades facade_configuration.properties de tipo Integer
	 * 
	 * @param nombre Nombre del parametro a recuperar
	 * @return Valor del parametro de configuracion
	 * @throws GenericFacadeException
	 */
	public static Integer getParametroInteger(String nombre) {
		String tmp = getConfiguration().getProperty(getEntorno() + "." + nombre, getConfiguration().getProperty(nombre));
		return (tmp != null) ? Integer.valueOf(tmp.trim()) : null;
//		return (tmp != null) ? new Integer(tmp.trim()) : null;
	}

}
