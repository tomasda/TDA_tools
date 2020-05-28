package com.tda.beans;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;


@Named
@ApplicationScoped
public class CoreBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String version = "1.0.0.1";
	
	
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}

}
