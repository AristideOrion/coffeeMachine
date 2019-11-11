package com.coffeeMachine.test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.coffeeMachine.Chocolate;
import com.coffeeMachine.Coffee;
import com.coffeeMachine.CoffeeMachine;
import com.coffeeMachine.Orange;
import com.coffeeMachine.Order;
import com.coffeeMachine.Tea;


@RunWith(value=PowerMockRunner.class)
@PrepareForTest(CoffeeMachine.class)
class CoffeeMachineTest {

	@Test
	protected
	void testShowMenu() {
		fail("Not yet implemented");
	}
	
	/* java.lang.reflect.inaccessibleObjectException, use whiteBox. I can't find solution for now.
	@Test
	void testMakeOrder() throws Exception
	{
		
		Order orderWait=new Order("T","1","0");
		Order orderExpect=Whitebox.invokeMethod(CoffeeMachine.class,"makeOrder","T",1);
		assertTrue(orderWait.getDrink().contains(orderExpect.getDrink()));
		assertTrue(orderWait.getNumberSugar().contains(orderExpect.getNumberSugar()));
		assertTrue(orderWait.getStick().contains(orderExpect.getStick()));
		assertTrue(orderWait.getMessage()==null);
	}*/
	
	
	
	@Test
	void testMakeOrder() throws Exception
	{
		
		Order orderWait=new Order(new Tea(),"1","0");
		Order orderExpect=CoffeeMachine.makeOrder("TEA", 1,false);
		assertTrue(orderWait.getDrink().getCodeMachine().contains(orderExpect.getDrink().getCodeMachine()));
		assertTrue(orderWait.getNumberSugar().contains(orderExpect.getNumberSugar()));
		assertTrue(orderWait.getStick().contains(orderExpect.getStick()));
		assertTrue(orderWait.getMessage()==null);
	}
	
	@Test
	void testMakeOrder1()
	{
		Order orderWaitMessage=new Order("M:Bonjour le monde");
		Order orderExpect=CoffeeMachine.makeOrderMessage("M:Bonjour le monde");
		assertTrue(orderWaitMessage.getMessage().contentEquals(orderExpect.getMessage()));
	}
	
	@Test
	void testdrinkMakerProtocolWithMessage()
	{
		String messageWait=CoffeeMachine.drinkMakerProtocol(new Order("hello the world"));
		String messageExcepted="M:hello the world";
		assertTrue(messageExcepted.contentEquals(messageWait));
	}
	
	@Test
	void testdrinkMakerProtocolWithSugarAndStick()
	{
		String messageWait=CoffeeMachine.drinkMakerProtocol(new Order(new Tea(),"1","0"));
		String messageExcepted="T:1:0";
		assertTrue(messageExcepted.contentEquals(messageWait));
	}
	
	@Test
	void testdrinkMaker()
	{
		CoffeeMachine.drinkMaker("T:2:0" );
		assertTrue(CoffeeMachine.output.contains("Drink maker makes 1 tea with 2 sugar and a stick"));
		CoffeeMachine.drinkMaker("T:1:0" );
		assertTrue(CoffeeMachine.output.contains("Drink maker makes 1 tea with 1 sugar and a stick"));
		CoffeeMachine.drinkMaker("T::" );
		assertTrue(CoffeeMachine.output.contains("Drink maker makes 1 tea with no sugar and therefore  no stick"));
		CoffeeMachine.drinkMaker("C:2:0" );
		assertTrue(CoffeeMachine.output.contains("Drink maker makes 1 coffee with 2 sugar and a stick"));
		CoffeeMachine.drinkMaker("C:1:0" );
		assertTrue(CoffeeMachine.output.contains("Drink maker makes 1 coffee with 1 sugar and a stick"));
		CoffeeMachine.drinkMaker("C::" );
		assertTrue(CoffeeMachine.output.contains("Drink maker makes 1 coffee with no sugar and therefore  no stick"));
		CoffeeMachine.drinkMaker("H:2:0" );
		assertTrue(CoffeeMachine.output.contains("Drink maker makes 1 Chocolate with 2 sugar and a stick"));
		CoffeeMachine.drinkMaker("H:1:0" );
		assertTrue(CoffeeMachine.output.contains("Drink maker makes 1 Chocolate with 1 sugar and a stick"));
		CoffeeMachine.drinkMaker("H::" );
		assertTrue(CoffeeMachine.output.contains("Drink maker makes 1 Chocolate with no sugar and therefore  no stick"));
	}
	@Test
	void testamountCorrect()
	{
		assertFalse(CoffeeMachine.checkAmountCorrect(new Coffee(), 0.4));
		assertTrue(CoffeeMachine.checkAmountCorrect(new Coffee(), 0.6));
		assertFalse(CoffeeMachine.checkAmountCorrect(new Tea(), 0.2));
		assertTrue(CoffeeMachine.checkAmountCorrect(new Tea(), 0.4));
		assertFalse(CoffeeMachine.checkAmountCorrect(new Chocolate(), 0.2));
		assertTrue(CoffeeMachine.checkAmountCorrect(new Chocolate(), 0.5));
		assertFalse(CoffeeMachine.checkAmountCorrect(new Orange(),0.4));
		assertTrue(CoffeeMachine.checkAmountCorrect(new Orange(), 0.6));
	}
	
	@Test
	void testremainingAmount()
	{
		assertTrue(CoffeeMachine.remainingAmount(new Tea(),0.2)==0.2);
		assertFalse(CoffeeMachine.remainingAmount(new Tea(),0.3)==0.4);
		assertTrue(CoffeeMachine.remainingAmount(new Coffee(),0.3)==0.2);
		assertFalse(CoffeeMachine.remainingAmount(new Coffee(),0.3)==0.1);
		assertTrue(CoffeeMachine.remainingAmount(new Chocolate(),0.2)==0.3);
		assertFalse(CoffeeMachine.remainingAmount(new Chocolate(),0.4)==0.2);
	}
	
	@Test
	void testbuildAndShowCustomerMessage()
	{
		fail("Not yet implemented");
	}
	
	@Test
	void testmakeOrderJuice()
	{
		Order order=CoffeeMachine.makeOrderJuice("O");
		assertTrue(order.getDrink().getCodeMachine().contains("O"));
		assertTrue(order.getDrink().getPrice().equals(0.6));
	}
}
