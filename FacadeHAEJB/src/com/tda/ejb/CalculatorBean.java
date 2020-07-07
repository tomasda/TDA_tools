package com.tda.ejb;

import java.io.Serializable;

import javax.ejb.Stateless;
import org.jboss.ejb3.annotation.SecurityDomain;
@SecurityDomain("other")
@Stateless
public class CalculatorBean implements CalculatorInterface , Serializable{

	private static final long serialVersionUID = 1L;
	
	@Override
	public String version() {
		return "1.0.0.1";
	}

	@Override
	public String value(String a) {
		return String.valueOf(a.length());
	}

	@Override
	public int add(int a, int b) {
		return a + b;
	}

	@Override
	public int substract(int a, int b) {
		return a - b;
	}

}
