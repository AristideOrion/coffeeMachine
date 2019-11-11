package com.coffeeMachine;

public class StateDrink {
	private Integer quantitySell;
	private Double montantSell;
	
	
	public StateDrink()
	{
		
	}
	
	public StateDrink(Integer quantity,Double montant)
	{
		this.quantitySell=quantity;
		this.montantSell=montant;
	}

	public Integer getQuantitySell() {
		return quantitySell;
	}

	public void setQuantitySell(Integer quantitySellV) {
		this.quantitySell = quantitySellV;
	}

	public Double getMontantSell() {
		return montantSell;
	}

	public void setMontantSell(Double montantSell) {
		this.montantSell = montantSell;
	}

}
