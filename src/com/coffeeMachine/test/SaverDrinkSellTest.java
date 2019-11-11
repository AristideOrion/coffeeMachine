package com.coffeeMachine.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.coffeeMachine.Coffee;
import com.coffeeMachine.Order;
import com.coffeeMachine.SaverDrinkSell;
import com.coffeeMachine.StateDrink;
@RunWith(PowerMockRunner.class)
@PrepareForTest({Map.class,StateDrink.class})
class SaverDrinkSellTest {

	@Test
	void testsaveDrinkSellTest() {
		Map<String,StateDrink> recordDrinkSellMock=PowerMock.createMock(Map.class);
		Order orderCustomer=new Order();
		StateDrink stateDrink=new StateDrink(1,0.6);
		orderCustomer.setDrink(new Coffee());
		EasyMock.expect(recordDrinkSellMock.isEmpty()).andReturn(false);
		EasyMock.expect(recordDrinkSellMock.containsKey("C")).andReturn(true);
		EasyMock.expect(recordDrinkSellMock.get("C")).andReturn(stateDrink);
		EasyMock.expect(recordDrinkSellMock.replace("C", stateDrink)).andReturn(stateDrink);
		EasyMock.expectLastCall();
		PowerMock.replayAll();
		assertTrue(SaverDrinkSell.saveDrinkSell(recordDrinkSellMock, orderCustomer));
		
	}
	@Test
	void testsaveDrinkSellTest1() throws Exception
	{
		Map<String,StateDrink> recordDrinkSellMock=PowerMock.createMock(Map.class);
		Order orderCustomer=new Order();
		StateDrink stateDrink=new StateDrink(1,0.6);
		StateDrink stateDrinkExpect=new StateDrink(1,0.6);
		orderCustomer.setDrink(new Coffee());
		EasyMock.expect(recordDrinkSellMock.isEmpty()).andReturn(true);
		PowerMock.expectNew(StateDrink.class,1,orderCustomer.getDrink().getPrice()).andReturn(stateDrinkExpect);
		EasyMock.expect(recordDrinkSellMock.put("C",new StateDrink(1,0.6) )).andReturn(stateDrink);
		PowerMock.replayAll();
		assertTrue(SaverDrinkSell.saveDrinkSell(recordDrinkSellMock, orderCustomer));
	}

}
