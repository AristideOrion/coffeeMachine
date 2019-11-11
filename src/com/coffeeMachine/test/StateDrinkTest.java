package com.coffeeMachine.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.coffeeMachine.StateDrink;

class StateDrinkTest {

	@Test
	void testStateDrink() {
		StateDrink stateDrink=new StateDrink(2,2.1);
		assertEquals(2.1, stateDrink.getMontantSell());
		assertEquals(2, stateDrink.getQuantitySell());
	}

}
