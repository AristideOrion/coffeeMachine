package com.coffeeMachine.test;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;
import org.powermock.api.easymock.PowerMock;

import com.coffeeMachine.Report;
import com.coffeeMachine.StateDrink;

class ReportTest {

	@Test
	void testReport() {
		Map<String,StateDrink> recordDrinkSellMock=PowerMock.createMock(Map.class);
		Set<Entry<String, StateDrink>>  setEntryMock=PowerMock.createMock(Set.class);
		Iterator<Entry<String, StateDrink>> iteratorEntryMock=PowerMock.createMock(Iterator.class);
		Entry<String, StateDrink> entryMock=PowerMock.createMock(Entry.class);
		EasyMock.expect(recordDrinkSellMock.isEmpty()).andReturn(false);
		EasyMock.expect(recordDrinkSellMock.entrySet()).andReturn( setEntryMock);
		EasyMock.expect(setEntryMock.iterator()).andReturn(iteratorEntryMock);
		EasyMock.expect(iteratorEntryMock.hasNext()).andReturn(false);
		EasyMock.expect(iteratorEntryMock.next()).andReturn(entryMock);
		EasyMock.expect(entryMock.getKey()).andReturn("C");
		EasyMock.expect(entryMock.getValue()).andReturn(new StateDrink());
		PowerMock.replayAll();
		assertFalse(Report.readAndShowReport(recordDrinkSellMock));
		
	}

}
