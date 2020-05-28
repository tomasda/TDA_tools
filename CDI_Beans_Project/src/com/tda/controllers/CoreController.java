package com.tda.controllers;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.tda.beans.CoreBean;


@Named
@ApplicationScoped
public class CoreController implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	CoreBean coreBean;
	
	public String getVersion() {
		return coreBean.getVersion();
	}
}
