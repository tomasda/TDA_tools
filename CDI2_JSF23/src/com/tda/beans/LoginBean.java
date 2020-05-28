package com.tda.beans;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


@Named(value="loginBean")
@SessionScoped
public class LoginBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String user;
	private String pass;
	private Timestamp loginTime;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Timestamp getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}
	@Override
	public String toString() {
		return "LoginBean [user=" + user + ", pass=" + pass + ", loginTime=" + loginTime + "]";
	}

}
