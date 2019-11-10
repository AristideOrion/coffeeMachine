package com.coffeeMachine.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.coffeeMachine.Coffee;

class CoffeeTest {

	@Test
	void testCoffee() {
		Coffee coffee=new Coffee();
		assertEquals(coffee.getPrice(), 0.6);
		assertEquals(coffee.getCodeMachine(),"C");
	}

}
