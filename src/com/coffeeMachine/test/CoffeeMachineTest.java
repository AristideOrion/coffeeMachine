package com.coffeeMachine.test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.coffeeMachine.CoffeeMachine;
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
		Order orderExpect=CoffeeMachine.makeOrder("TEA", 1);
		assertTrue(orderWait.getDrink().getCodeMachine().contains(orderExpect.getDrink().getCodeMachine()));
		assertTrue(orderWait.getNumberSugar().contains(orderExpect.getNumberSugar()));
		assertTrue(orderWait.getStick().contains(orderExpect.getStick()));
		assertTrue(orderWait.getMessage()==null);
	}
	
	@Test
	void testMakeOrder1()
	{
		Order orderWaitMessage=new Order("M:Bonjour le monde");
		Order orderExpect=CoffeeMachine.makeOrder("M:Bonjour le monde");
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
		assertFalse(CoffeeMachine.amountCorrect("COFFEE", 0.4));
		assertTrue(CoffeeMachine.amountCorrect("COFFEE", 0.6));
		assertFalse(CoffeeMachine.amountCorrect("TEA", 0.2));
		assertTrue(CoffeeMachine.amountCorrect("TEA", 0.4));
		assertFalse(CoffeeMachine.amountCorrect("CHOCOLATE", 0.2));
		assertTrue(CoffeeMachine.amountCorrect("CHOCOLATE", 0.5));
	}
	
	@Test
	void testremainingAmount()
	{
		assertTrue(CoffeeMachine.remainingAmount("T",0.2)==0.2);
		assertFalse(CoffeeMachine.remainingAmount("T",0.3)==0.4);
		assertTrue(CoffeeMachine.remainingAmount("C",0.3)==0.3);
		assertFalse(CoffeeMachine.remainingAmount("C",0.3)==0.2);
		assertTrue(CoffeeMachine.remainingAmount("H",0.2)==0.3);
		assertFalse(CoffeeMachine.remainingAmount("H",0.3)==0.1);
	}
}
