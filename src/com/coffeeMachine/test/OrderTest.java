package com.coffeeMachine.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.coffeeMachine.Chocolate;
import com.coffeeMachine.Coffee;
import com.coffeeMachine.Orange;
import com.coffeeMachine.Order;
import com.coffeeMachine.Tea;

class OrderTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testOrderTea() {
		Order orderCustomerTest=new Order(new Tea(),"0","0");
		assertTrue(orderCustomerTest.getDrink().getCodeMachine().contains("T"));
		assertTrue(orderCustomerTest.getNumberSugar().contains("0"));
		assertTrue(orderCustomerTest.getStick().contains("0"));
		assertTrue(orderCustomerTest.getInstructionForWithoutSugarDrinkMaker().contentEquals("T::"));
		orderCustomerTest.setNumberSugar("1");
		assertTrue(orderCustomerTest.getInstructionForWithSugarStickDrinkMaker().contentEquals("T:1:0"));
		orderCustomerTest.setNumberSugar("2");
		assertTrue(orderCustomerTest.getInstructionForWithSugarStickDrinkMaker().contentEquals("T:2:0"));
	}
	
	@Test
	void testOrderChocolate()
	{
		Order orderCustomerTest=new Order(new Chocolate(),"0","0");
		assertTrue(orderCustomerTest.getDrink().getCodeMachine().contains("H"));
		assertTrue(orderCustomerTest.getNumberSugar().contains("0"));
		assertTrue(orderCustomerTest.getStick().contains("0"));
		assertTrue(orderCustomerTest.getInstructionForWithoutSugarDrinkMaker().contentEquals("H::"));
		orderCustomerTest.setNumberSugar("1");
		assertTrue(orderCustomerTest.getInstructionForWithSugarStickDrinkMaker().contentEquals("H:1:0"));
		orderCustomerTest.setNumberSugar("2");
		assertTrue(orderCustomerTest.getInstructionForWithSugarStickDrinkMaker().contentEquals("H:2:0"));
	}
	
	@Test
	void testOrderCoffee()
	{
		Order orderCustomerTest=new Order(new Coffee(),"0","0");
		assertTrue(orderCustomerTest.getDrink().getCodeMachine().contains("C"));
		assertTrue(orderCustomerTest.getNumberSugar().contains("0"));
		assertTrue(orderCustomerTest.getStick().contains("0"));
		assertTrue(orderCustomerTest.getInstructionForWithoutSugarDrinkMaker().contentEquals("C::"));
		orderCustomerTest.setNumberSugar("1");
		assertTrue(orderCustomerTest.getInstructionForWithSugarStickDrinkMaker().contentEquals("C:1:0"));
		orderCustomerTest.setNumberSugar("2");
		assertTrue(orderCustomerTest.getInstructionForWithSugarStickDrinkMaker().contentEquals("C:2:0"));
		
	}
	
	@Test
	void testOrderMessage()
	{
		Order orderCustomerMessage=new Order("Hello");
		assertTrue(orderCustomerMessage.getInstructionForWithMessageForDrinkMaker().contentEquals("M:Hello"));
		assertNull(orderCustomerMessage.getInstructionForWithSugarStickDrinkMaker());
		
	}
	
	@Test
	void testOrderOrange()
	{
		Order orderCustomerTest=new Order(new Orange());
		assertTrue(orderCustomerTest.getDrink().getCodeMachine().contains("O"));
		assertNull(orderCustomerTest.getNumberSugar());
		assertNull(orderCustomerTest.getStick());
		assertTrue(orderCustomerTest.getInstructionForOrangeDrinkMaker().contentEquals("O::"));
		
		
	}
	

}
