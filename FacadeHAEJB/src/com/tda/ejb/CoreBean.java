package com.tda.ejb;

import java.io.Serializable;

import javax.ejb.Stateless;
import org.jboss.ejb3.annotation.SecurityDomain;
@SecurityDomain("other")
@Stateless
public class CoreBean implements Serializable, CoreInterface{

	private static final long serialVersionUID = 1L;
	private int count = 0;
	
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

	@Override
	public void increment() {
		this.count++;
		
	}

	@Override
	public void decrement() {
		this.count--;
	}

	@Override
	public int getCount() {
		return this.count;
	}
}
