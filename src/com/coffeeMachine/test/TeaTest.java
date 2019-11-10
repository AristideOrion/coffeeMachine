package com.coffeeMachine.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.coffeeMachine.Tea;

class TeaTest {

	@Test
	void test() {
		Tea tea=new Tea();
		assertEquals(tea.getPrice(), 0.4);
		assertEquals(tea.getCodeMachine(),"T");
	}

}
