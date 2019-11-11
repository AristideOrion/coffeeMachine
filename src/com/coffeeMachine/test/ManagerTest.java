package com.coffeeMachine.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.coffeeMachine.Manager;

public class ManagerTest {
	
	@Test
	 void testmanager()
	{
		Manager manager=new Manager();
		assertEquals("Manager", manager.getCodeUser());
	}

}
