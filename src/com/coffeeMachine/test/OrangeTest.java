package com.coffeeMachine.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.coffeeMachine.Orange;

class OrangeTest {

	@Test
	void test() {
		Orange orange=new Orange();
		assertTrue(orange.getCodeMachine()=="O");
		assertTrue(orange.getPrice()==0.6);
		
	}

}
