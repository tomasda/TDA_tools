package com.opencanarias.bean;

import java.io.IOException;
import java.io.Serializable;
import java.security.Principal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.opencanarias.objects.O_LDAP;
import com.opencanarias.utils.ConfigUtils;
//import com.opencanarias.utils.Constantes;


@Named
@SessionScoped
public class CommonBean implements Serializable{
	private static final long serialVersionUID = -796489608974652537L;
	
	private String message = "";
	//Config values
	private String version = "";
	private String logoLogin;
	private String logoHeadder;
	private String logoLoadding;

	
	private String login;
	private String userName;
	private String numIdentification;
	private String appAccess;
	//private O_LDAP ldapUser =  new O_LDAP();
	
	public CommonBean(){

		message = "";
		version = ConfigUtils.getParametro("version");
		logoLogin = ConfigUtils.getParametro("logo.login");
		logoHeadder = ConfigUtils.getParametro("logo.headder");
		logoLoadding = ConfigUtils.getParametro("logo.loadding");
		
		 
	}
	
		
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getLogin() {
		login();
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAppAccess() {
		return appAccess;
	}

	public void setAppAccess(String appAccess) {
		this.appAccess = appAccess;
	}

	public String getVersion() {
		return version;
	}

	public String getLogoLogin() {
		return logoLogin;
	}

	public String getLogoHeadder() {
		return logoHeadder;
	}

	public String getLogoLoadding() {
		return logoLoadding;
	}

	public void login(){
		
		//Principal principal = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		Principal principal = (Principal) context.getUserPrincipal();
		numIdentification = principal.getName();
		setUserName(principal.getName());

		
		String strBusqueda="";
		ArrayList<O_LDAP> consultaLDAP = new ArrayList<O_LDAP>();
			if (numIdentification!=null&numIdentification!=""){
				strBusqueda=numIdentification;
			
				if (!strBusqueda.equals("")){
					try {
						consultaLDAP=com.opencanarias.utils.COMMON.buscarUsuarioLDAP(strBusqueda);//strBusqueda);
					} catch (IOException e) {
						// Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// Auto-generated catch block
						e.printStackTrace();
					}
					int nExp=consultaLDAP.size();
					// CANTIDAD DE USUARIOS ENCONTRADOS System.out.println(nExp);
					
					int index=0;
					while (nExp>index){
					// IMPRIME LOS PERMISOS A LAS APLICACIONES AUTORIZADAS. System.out.println (consultaLDAP.get(index).getOU());
						setUserName(consultaLDAP.get(index).getCN());
						setAppAccess(consultaLDAP.get(index).getOU());
						//ldapUser.setCN(consultaLDAP.get(index).getCN());
						//ldapUser.setOU(consultaLDAP.get(index).getOU());
						setLogin("true");
					index++;
					}
				}else{
					numIdentification="Sin Resultados";
					setLogin("false");
				}

			}
	}
	
	public String enabled(String app){
		String data="disabled";
		if (app!=null&&!app.equals("")){
				Pattern p = Pattern.compile(app,Pattern.CASE_INSENSITIVE+Pattern.LITERAL);
			 Matcher m = p.matcher(appAccess);
			if (m.find()==true){
				data="";
			}
		}
		return data;
	}
	
	public String url(String app){
		String data;
		if (enabled(app)!="disabled"){
			data = "window.location='"+(String)ConfigUtils.getParametro("url."+app)+"'";
		}else{
			data="";
		}
		return data;
	}

}
