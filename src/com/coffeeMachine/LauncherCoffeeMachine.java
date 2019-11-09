package com.coffeeMachine;

import java.util.Scanner;

public class LauncherCoffeeMachine {

	
private Order order;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		showMenu();
	}
	
	static void showMenu()

	{
		Boolean repeatMenu=true;
		while(repeatMenu) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Bienvennue que désirez vous boire ?");
		System.out.println("Veuillez tapez C pour le coffee, T pour le tea, H pour le chocolate, M pour  écrire un message");
		String choix=scan.nextLine();
		if(!choix.contains("C") && !choix.contains("T") && !choix.contains("H") && !choix.contains("M"))
		{
			System.out.println("Veuillez reprendre svp, l'instruction saisie ne correspond pas");
		}
		if(choix.contains("M"))
		{
			System.out.println("Veuillez saisir votre message");
			Scanner scanMess=new Scanner(System.in);
			String messageToAffiche=scanMess.next();
			scanMess.nextLine();
			
			
		}
		if(choix.contains("C") ||choix.contains("T")||choix.contains("H"))
		{
			System.out.println("Veuillez tapez la quantité de sucre que vous désirez");
			Integer choixSucre =scan.nextInt();
			
		}
		
		System.out.println("Désirez vous reprendre votre commande? si oui tapez 1 sinon tapez 2");
		int i=scan.nextInt();
		if(i!=1)
		{
			repeatMenu=false;
		}
		
		
	}
	

   }
	 public static Order makeOrder(String drink,Integer sugar)
	{	Order orderCustomer=new Order();
		orderCustomer.setDrink(drink);
		orderCustomer.setNumberSugar(sugar.toString());
		if(sugar!=0)
		{
			orderCustomer.setStick("stick");
		}
		return orderCustomer;
	}
	public static Order makeOrder(String message)
	{
		Order orderForShowMessage=new Order();
		orderForShowMessage.setMessage("M:"+message);
		return orderForShowMessage;
		
	}
	
	public static void drinkMakerProtocol()
	{
		
	}
	
	
}
