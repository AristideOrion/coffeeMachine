package com.coffeeMachine.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.Console;

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
		Order orderWait=new Order("T","1","0");
		Order orderExpect=LauncherCoffeeMachine.makeOrder("T",1);
		assertTrue(orderWait.getDrink().contains(orderExpect.getDrink()));
		assertTrue(orderWait.getNumberSugar().contains(orderExpect.getNumberSugar()));
		assertTrue(orderWait.getStick().contains(orderExpect.getStick()));
		assertTrue(orderWait.getMessage()==null);
	}
	
	@Test
	void testMakeOrder1()
	{
		Order orderWaitMessage=new Order("M:Bonjour le monde");
		Order orderExpect=LauncherCoffeeMachine.makeOrder("M:Bonjour le monde");
		assertTrue(orderWaitMessage.getMessage().contentEquals(orderExpect.getMessage()));
	}
	
	@Test
	void testdrinkMakerProtocolWithMessage()
	{
		String messageWait=LauncherCoffeeMachine.drinkMakerProtocol(new Order("hello the world"));
		String messageExcepted="M:hello the world";
		assertTrue(messageExcepted.contentEquals(messageWait));
	}
	
	@Test
	void testdrinkMakerProtocolWithSugarAndStick()
	{
		String messageWait=LauncherCoffeeMachine.drinkMakerProtocol(new Order("T","1","0"));
		String messageExcepted="T:1:0";
		assertTrue(messageExcepted.contentEquals(messageWait));
	}
	
	@Test
	void testshowCommandCustomer()
	{
		fail("implement yet");
	}

}
