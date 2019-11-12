package com.coffeeMachine;

import java.util.Map;
import java.util.Map.Entry;

public class Report {


	public static Boolean readAndShowReport(Map<String,StateDrink> recordingsSold)
	{	Boolean reportIsShow=false;
	if(!recordingsSold.isEmpty())
	{
		System.out.println("***********************Report manager**********************");
		for (Entry<String, StateDrink> entry : recordingsSold.entrySet()) {
			System.out.println("*********************************************");
			System.out.println("Drinks code  : " + entry.getKey()+" Count sold: " + entry.getValue().getQuantitySell()+" Cash:"+entry.getValue().getMontantSell()+"euros");
			System.out.println("*********************************************");
		}
	}	
	return reportIsShow;

	}
}
