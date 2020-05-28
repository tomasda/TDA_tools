package com.tda.controllers;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import com.tda.beans.LoginBean;

@Named
public class LoginController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	LoginBean loginBean;

	public void login() {
		
		
		System.out.println(loginBean.getUser());
		System.out.println(loginBean.getPass());
	}
	
}
