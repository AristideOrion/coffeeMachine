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
		LauncherCoffeeMachine.showCommandCustomer("T:2:0" );
		assertTrue(LauncherCoffeeMachine.output.contains("Drink maker makes 1 tea with 2 sugar and a stick"));
		LauncherCoffeeMachine.showCommandCustomer("T:1:0" );
		assertTrue(LauncherCoffeeMachine.output.contains("Drink maker makes 1 tea with 1 sugar and a stick"));
		LauncherCoffeeMachine.showCommandCustomer("T::" );
		assertTrue(LauncherCoffeeMachine.output.contains("Drink maker makes 1 tea with no sugar and therefore  no stick"));
		LauncherCoffeeMachine.showCommandCustomer("C:2:0" );
		assertTrue(LauncherCoffeeMachine.output.contains("Drink maker makes 1 coffee with 2 sugar and a stick"));
		LauncherCoffeeMachine.showCommandCustomer("C:1:0" );
		assertTrue(LauncherCoffeeMachine.output.contains("Drink maker makes 1 coffee with 1 sugar and a stick"));
		LauncherCoffeeMachine.showCommandCustomer("C::" );
		assertTrue(LauncherCoffeeMachine.output.contains("Drink maker makes 1 coffee with no sugar and therefore  no stick"));
		LauncherCoffeeMachine.showCommandCustomer("H:2:0" );
		assertTrue(LauncherCoffeeMachine.output.contains("Drink maker makes 1 Chocolate with 2 sugar and a stick"));
		LauncherCoffeeMachine.showCommandCustomer("H:1:0" );
		assertTrue(LauncherCoffeeMachine.output.contains("Drink maker makes 1 Chocolate with 1 sugar and a stick"));
		LauncherCoffeeMachine.showCommandCustomer("H::" );
		assertTrue(LauncherCoffeeMachine.output.contains("Drink maker makes 1 Chocolate with no sugar and therefore  no stick"));
	}
}
