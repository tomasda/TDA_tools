package com.opencanarias.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.opencanarias.objects.O_LDAP;
import com.opencanarias.utils.ADAuthenticator;

public class COMMON {
	public static Properties prop = new Properties();
	
	
	public static  Properties getPropValues() throws IOException {

		//prop = new Properties();
		String propFileName = "config.properties";
		InputStream inputStream = com.opencanarias.utils.COMMON.class.getClassLoader().getResourceAsStream(propFileName);
		
		if (inputStream != null) {
			prop.load(inputStream);
		} else {
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}
		
		// get the property value and print it out
		String user = prop.getProperty("user");
		System.out.println("Login by user=" + user);
		return prop;
	}

	@SuppressWarnings("rawtypes")
	public static ArrayList<O_LDAP> buscarUsuarioLDAP(String consulta) throws IOException, SQLException, ClassNotFoundException{
		ArrayList<O_LDAP> listaUsuarios = new ArrayList<O_LDAP>();//, número de expediente, asuntos expediente
		ADAuthenticator adAuthenticator = new ADAuthenticator();
		//Obtener datos del LDAP
		List<Map<String, Object>> attrsList = adAuthenticator.authenticate(consulta);    //"admin-ae3","1",consulta);
		Map<String,Object> attrs = null;
			//Lógica de la consulta.
			int numRows = attrsList.size(); int index = 0;  
			if (numRows<100){
				while(numRows>index) {
					O_LDAP user = new O_LDAP();
					attrs = attrsList.get(index);
					  if (attrs != null) {
					      for (String attrKey : attrs.keySet()) {
					          if (attrs.get(attrKey) instanceof String) {
					        	//System.out.println(attrKey +": "+attrs.get(attrKey));
								  if (attrKey.equals("cn")){
									  user.setCN((String) attrs.get(attrKey));
								  }
								  if (attrKey.equals("carLicense")){
									  user.setCarLicense((String) attrs.get(attrKey));
								  }
								  if (attrKey.equals("businessCategory")){
								    	  user.setBusinessCategory((String) attrs.get(attrKey));
								  }
								  if (attrKey.equals("ou")){
							    	  user.setOU((String) attrs.get(attrKey));
							      }
								  } else {
									  String temp="";
										  	if (attrKey.equals("businessCategory")){
											  for (Object o : (HashSet)attrs.get(attrKey)) {
											      //System.out.println("\t value: " +o);
											  temp = temp+ (String) o+",";
									          }
											// SE REGISTRAN LOS ROLES DE DEPARTAMENTO
											user.setBusinessCategory(temp);
									        }
									        if (attrKey.equals("ou")){
											  for (Object o : (HashSet)attrs.get(attrKey)) {
												  temp = temp+ (String) o+",";
									          }
											  // SE REGISTRAN LOS ROLES DE APLICACIONES.
											  user.setOU(temp);
									        }
										 }
								   }
					          
					  } else {
					      System.out.println("Attributes are null!");
					      user.setParametros("No existe el atributo", "No existe el atributo", "No existe el atributo");
					  }
					  index++;
					  listaUsuarios.add(user);
				}
			}else{
				listaUsuarios=null;
			}
		//Devolver la lista de usuarios.
		return listaUsuarios;
	}
}