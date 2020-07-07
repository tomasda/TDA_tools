package com.tda.ejb;

import javax.ejb.Remote;

@Remote
public interface CounterInterface {
	void increment();
	void decrement();
	int getCount();
}
