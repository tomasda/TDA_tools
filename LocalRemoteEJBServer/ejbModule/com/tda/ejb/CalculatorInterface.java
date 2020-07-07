package com.tda.ejb;

import javax.ejb.Remote;

@Remote
public interface CalculatorInterface{
	String version();
	String value(String a);
	int add (int a, int b);
	int substract(int a, int b);
}
