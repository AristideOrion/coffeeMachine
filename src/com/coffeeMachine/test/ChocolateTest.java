package com.coffeeMachine.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.coffeeMachine.Chocolate;

class ChocolateTest {

	@Test
	void testChocolate() {
		Chocolate chocolate=new Chocolate();
		assertEquals(chocolate.getPrice(), 0.5);
		assertEquals(chocolate.getCodeMachine(), "H");
	}

}
