package com.tda.beans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;


@Named(value = "coreBean")
@ApplicationScoped
public class CoreBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String version;
	private String title;
	private boolean enabled;
	private List<String> stringList;
	private HashMap<String, String> hashMap;
	
	
	public CoreBean() {
		this.version  = "1.0.0.1";
		this.title = "CDI 2 | JSF 2.3";
	}
	
	
	public void buttonAction() {
		
	}
	
	/**
	 * Getters & Setters
	 * @return
	 */
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public List<String> getStringList() {
		return stringList;
	}


	public void setStringList(List<String> stringList) {
		this.stringList = stringList;
	}


	public HashMap<String, String> getHashMap() {
		return hashMap;
	}


	public void setHashMap(HashMap<String, String> hashMap) {
		this.hashMap = hashMap;
	}
	

}
