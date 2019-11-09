package com.coffeeMachine.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.coffeeMachine.Order;

class OrderTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testOrderStringStringString() {
		Order orderCustomerTest=new Order("T","0","0","");
		assertTrue(orderCustomerTest.getDrink().contains("T"));
		assertTrue(orderCustomerTest.getNumberSugar().contains("0"));
		assertTrue(orderCustomerTest.getStick().contains("0"));
	}

}
