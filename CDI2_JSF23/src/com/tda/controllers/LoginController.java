package com.tda.controllers;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.tda.beans.LoginBean;


@Named(value = "loginController")
@ApplicationScoped
public class LoginController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	LoginBean loginBean;
	
	public String login() {
		String result="login";
		boolean validUser = validLogin(loginBean.getUser(),loginBean.getPass());
		
		if (validUser) {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			loginBean.setLoginTime(timestamp);
			result="core";
		}
		// En Faces la regla de navegación  si validUser es true va a core.xhtml
		return result;
	}


	
	/**
	 * Este método hace las funciones de validación de Login
	 * @param user
	 * @param pass
	 * @return
	 */
	private boolean validLogin(String user, String pass) {
		boolean valid = false;
		if (!user.isEmpty()&&!pass.isEmpty()) {
			valid=true;
		}
		return valid;
	}

}
