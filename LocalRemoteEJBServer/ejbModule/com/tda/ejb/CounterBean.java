package com.tda.ejb;

import java.io.Serializable;

import javax.ejb.Stateless;

@Stateless
public class CounterBean implements CounterInterface, Serializable {

	private static final long serialVersionUID = 1L;
	private int count = 0;
	
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
