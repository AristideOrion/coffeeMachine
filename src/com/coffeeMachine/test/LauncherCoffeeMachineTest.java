package com.coffeeMachine.test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.coffeeMachine.LauncherCoffeeMachine;
import com.coffeeMachine.Order;

class LauncherCoffeeMachineTest {

	@Test
	void testShowMenu() {
		fail("Not yet implemented");
	}
	@Test
	void testMakeOrder()
	{
		Order orderWait=new Order("Tea","1","stick");
		Order orderExpect=LauncherCoffeeMachine.makeOrder("Tea",1);
		assertTrue(orderWait.getDrink().contains(orderExpect.getDrink()));
		assertTrue(orderWait.getNumberSugar().contains(orderExpect.getNumberSugar()));
		assertTrue(orderWait.getStick().contains(orderExpect.getStick()));
		assertTrue(orderWait.getMessage()==null);
	}
	
	@Test
	void testMakeOrder1()
	{
		Order orderWaitMessage=new Order("M:Bonjour le monde");
		Order orderExpect=LauncherCoffeeMachine.makeOrder("Bonjour le monde");
		assertTrue(orderWaitMessage.getMessage().contains(orderExpect.getMessage()));
	}

}
