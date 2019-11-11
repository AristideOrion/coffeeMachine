package com.coffeeMachine.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.coffeeMachine.Customer;

public class CustomerTest {

	@Test
	void testCustomer() {
	Customer customerTest=new Customer();
	assertEquals("Customer", customerTest.getCodeUser());
	}

}
