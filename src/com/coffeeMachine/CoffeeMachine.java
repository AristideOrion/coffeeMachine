package com.coffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {

	
	private static final String MESSAGECUSTOMER = "M";
	private static final String CHOCOLATE = "H";
	private static final String TEA = "T";
	private static final String COFFEE = "C";
	public static String output;
	
	
	public static void showMenu()

	{
		Boolean repeatMenu=true;
		while(repeatMenu) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Bienvennue que désirez vous boire ?");
		System.out.println("Veuillez tapez C pour le coffee, T pour le tea, H pour le chocolate, M pour  écrire un message");
		String choix=scan.nextLine();
		if(!choix.contains(COFFEE) && !choix.contains(TEA) && !choix.contains(CHOCOLATE) && !choix.contains(MESSAGECUSTOMER))
		{
			System.out.println("Veuillez reprendre svp, l'instruction saisie ne correspond pas");
		}
		if(choix.contains(MESSAGECUSTOMER))
		{
			System.out.println("Veuillez saisir votre message");
			Scanner scanMess=new Scanner(System.in);
			String messageToAffiche=scanMess.nextLine();
			drinkMaker(drinkMakerProtocol(makeOrder(messageToAffiche)) );
			showCommandCustomer(output);
			
		}
		if(choix.contains(COFFEE) ||choix.contains(TEA)||choix.contains(CHOCOLATE))
		{
			System.out.println("Veuillez tapez la quantité de sucre que vous désirez");
			Integer choixSucre =scan.nextInt();
			scan.nextLine();
			System.out.println("Veuillez entrez le montant de votre boisson. Tea :0.4euros, Coffee : 0.6euros, Chocolate: 0.5euros");
			Double amountDrink = null;
			try {
				 amountDrink=scan.nextDouble();
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			
			if(!amountCorrect(choix, amountDrink))
			{
			Double remaining=remainingAmount(choix, amountDrink);
			output="Il manque "+remaining+" euros au montant saisi";
			}
			else
			{
				drinkMaker(drinkMakerProtocol(makeOrder(choix,choixSucre)));
			}
			
			showCommandCustomer(output);
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
			scan.close();
		}
		
	}
	

   }
	 public  static Order makeOrder(String choix,Integer sugar)
	 
	{	
		 Order orderCustomer=new Order();
		 Drink drinkCustomer = returnDrinks(choix);
		 orderCustomer.setDrink(drinkCustomer);
		 orderCustomer.setNumberSugar(sugar.toString());
				if(sugar!=0)
				{
					orderCustomer.setStick("0");
				}
		 
		 
		
		return orderCustomer;
	}
	 
	public  static Drink returnDrinks(String choix) {
		Drink drinkCustomer = null;
		 if(choix.contains(COFFEE))
		 {
			
			 drinkCustomer= new Coffee();
		 }
		 if(choix.contains(CHOCOLATE))
		 {	
			 drinkCustomer=new Chocolate();
		 }
		 if(choix.contains(TEA))
		 {
			 
			 drinkCustomer=new Tea();
		 }
		return drinkCustomer;
	}
	public static Order makeOrder(String message)
	{
		Order orderForShowMessage=new Order();
		orderForShowMessage.setMessage(message);
		return orderForShowMessage;
		
	}
	
	public static  String drinkMakerProtocol(Order order)
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
	
	
	
	public static  void drinkMaker(String messageProtocol)
	{
		
		if(messageProtocol.contains("M:"))
		{
			output=messageProtocol;
			
		}
		if(messageProtocol.contains("T:1:0"))
		{
			output="Drink maker makes 1 tea with 1 sugar and a stick";
			System.out.println(output);
		}
		if(messageProtocol.contains("T:2:0"))
		{
			output="Drink maker makes 1 tea with 2 sugar and a stick";
			
		}
		if(messageProtocol.contains("T::"))
		{
			output="Drink maker makes 1 tea with no sugar and therefore  no stick";
			
		}
		if(messageProtocol.contains("C:1:0"))
		{
			output="Drink maker makes 1 coffee with 1 sugar and a stick";
			
		}
		if(messageProtocol.contains("C:2:0"))
		{
			output="Drink maker makes 1 coffee with 2 sugar and a stick";
			
		}
		if(messageProtocol.contains("C::"))
		{
			output="Drink maker makes 1 coffee with no sugar and therefore  no stick";
			
		}
		if(messageProtocol.contains("H:1:0"))
		{
			output="Drink maker makes 1 Chocolate with 1 sugar and a stick";
			
		}
		if(messageProtocol.contains("H:2:0"))
		{
			output="Drink maker makes 1 Chocolate with 2 sugar and a stick";
			
		}
		if(messageProtocol.contains("H::"))
		{
			output="Drink maker makes 1 Chocolate with no sugar and therefore  no stick";
			
		}
	}
	
	
	public static void showCommandCustomer(String output)
	{
			
			System.out.println("*******VOTRE COMMANDE**************");
			System.out.println("***"+ output +"****");
			System.out.println("***********************************");
		
		
	}
	
	public static Boolean amountCorrect(String choix ,Double amountInput)
	
	{
		Boolean correct=false;
		Drink drinkCustomer = returnDrinks(choix);
		if(amountInput>drinkCustomer.getPrice()||amountInput.equals(drinkCustomer.getPrice()))
		{
			correct=true;
		}
		return correct;
		
		
	}
	
	public static Double remainingAmount(String choix,Double amountInput)
	{
		Drink drinkCustomer=returnDrinks(choix);
		return drinkCustomer.getPrice()-amountInput;
		
	}
	
	
}
