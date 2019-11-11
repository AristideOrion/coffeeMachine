package com.coffeeMachine;

import java.util.Map;

public class SaverDrinkSell {
	private SaverDrinkSell() {
		
	}
	
	public static Boolean  saveDrinkSell(Map <String,StateDrink> recordDrinkSell, Order orderCustomer) {
		Boolean state=false;
		if(recordDrinkSell.isEmpty())
		{
			recordDrinkSell.put(orderCustomer.getDrink().getCodeMachine(),new StateDrink(1,orderCustomer.getDrink().getPrice()));
			state=true;
		}
		else
		{
			if(recordDrinkSell.containsKey(orderCustomer.getDrink().codeMachine))
			{
				updaterecordDrinkSell(recordDrinkSell,orderCustomer);
				state=true;
			}
		}
		 
		return state;
	}
	private static void updaterecordDrinkSell(Map<String, StateDrink> recordDrinkSell,Order orderCustomer)
	{
		StateDrink stateDrink= recordDrinkSell.get(orderCustomer.getDrink().codeMachine);
		stateDrink.setQuantitySell(stateDrink.getQuantitySell()+1);
		stateDrink.setMontantSell(stateDrink.getMontantSell()+orderCustomer.getDrink().getPrice());
		recordDrinkSell.replace(orderCustomer.getDrink().codeMachine, stateDrink);
	}

}
