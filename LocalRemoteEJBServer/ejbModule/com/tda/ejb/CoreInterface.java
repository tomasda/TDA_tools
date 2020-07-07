package com.tda.ejb;

import javax.ejb.Remote;

@Remote
public interface CoreInterface {
	String version();
	void increment();
	void decrement();
	int getCount();
	String value(String a);
	int add (int a, int b);
	int substract(int a, int b);
}
