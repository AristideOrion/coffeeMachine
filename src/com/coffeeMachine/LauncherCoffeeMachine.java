package com.coffeeMachine;

import java.util.Scanner;

public class LauncherCoffeeMachine {

	
	public static String output;
	public static void main(String[] args) {
		
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
		scan.close();
		if(!choix.contains("C") && !choix.contains("T") && !choix.contains("H") && !choix.contains("M"))
		{
			System.out.println("Veuillez reprendre svp, l'instruction saisie ne correspond pas");
		}
		if(choix.contains("M"))
		{
			System.out.println("Veuillez saisir votre message");
			Scanner scanMess=new Scanner(System.in);
			String messageToAffiche=scanMess.nextLine();
			scanMess.close();
			showCommandCustomer(drinkMakerProtocol(makeOrder(messageToAffiche)) );
			
			
		}
		if(choix.contains("C") ||choix.contains("T")||choix.contains("H"))
		{
			System.out.println("Veuillez tapez la quantité de sucre que vous désirez");
			Integer choixSucre =scan.nextInt();
			showCommandCustomer(drinkMakerProtocol(makeOrder(choix,choixSucre)));
		}
		
		System.out.println("Désirez vous reprendre votre commande? si oui tapez 1 sinon tapez 2");
		int i = 0;
		try{
			 i=scan.nextInt();
		}catch(Exception e)
		{
			System.out.println("Erreur dans la saisie"+e.getMessage());
		}
		
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
			orderCustomer.setStick("0");
		}
		return orderCustomer;
	}
	public static Order makeOrder(String message)
	{
		Order orderForShowMessage=new Order();
		orderForShowMessage.setMessage(message);
		return orderForShowMessage;
		
	}
	
	public static String drinkMakerProtocol(Order order)
	{
		String message = null;
		if(order.getMessage()!=null)
		{
			 message=order.getInstructionForWithMessageForDrinkMaker();
			 return message;
		}
		if(order.getStick()!=null)
		{
			message=order.getInstructionForWithSugarStickDrinkMaker();
			return message;
		}
		if(order.getNumberSugar().contentEquals("0"))
		{
			message=order.getInstructionForWithoutSugarDrinkMaker();
			return message;
		}
		return message;
	}
	
	public static void showCommandCustomer(String messageProtocol)
	{
		
		if(messageProtocol.contains("M:"))
		{
			output=messageProtocol;
			System.out.println(output);
		}
		if(messageProtocol.contains("T:1:0"))
		{
			output="Drink maker makes 1 tea with 1 sugar and a stick";
			System.out.println(output);
		}
		if(messageProtocol.contains("T:2:0"))
		{
			output="Drink maker makes 1 tea with 2 sugar and a stick";
			System.out.println(output);
		}
		if(messageProtocol.contains("T::"))
		{
			output="Drink maker makes 1 tea with no sugar and therefore  no stick";
			System.out.println(output);
		}
		if(messageProtocol.contains("C:1:0"))
		{
			output="Drink maker makes 1 coffee with 1 sugar and a stick";
			System.out.println(output);
		}
		if(messageProtocol.contains("C:2:0"))
		{
			output="Drink maker makes 1 coffee with 2 sugar and a stick";
			System.out.println(output);
		}
		if(messageProtocol.contains("C::"))
		{
			output="Drink maker makes 1 coffee with no sugar and therefore  no stick";
			System.out.println(output);
		}
		if(messageProtocol.contains("H:1:0"))
		{
			output="Drink maker makes 1 Chocolate with 1 sugar and a stick";
			System.out.println(output);
		}
		if(messageProtocol.contains("H:2:0"))
		{
			output="Drink maker makes 1 Chocolate with 2 sugar and a stick";
			System.out.println();
		}
		if(messageProtocol.contains("H::"))
		{
			output="Drink maker makes 1 Chocolate with no sugar and therefore  no stick";
			System.out.println(output);
		}
	}
	
	
}
