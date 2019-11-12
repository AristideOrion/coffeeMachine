package com.coffeeMachine;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CoffeeMachine {


	private static final String MESSAGECUSTOMER = "M";
	private static final String CHOCOLATE = "H";
	private static final String TEA = "T";
	private static final String COFFEE = "C";
	private static final String ORANGE="O";
	public static String output;
	protected static Map<String,StateDrink> records=new HashMap<String, StateDrink>();


	public static void showMenu() 

	{
		Boolean repeatMenu=true;
		while(repeatMenu) {
			Scanner scan=new Scanner(System.in);
			System.out.println("**********************COFFE MACHINE************************");
			System.out.println("Bienvennue que désirez vous boire ?");
			System.out.println("Veuillez tapez "+COFFEE+" pour le coffee, "+TEA+" pour le tea, "+CHOCOLATE+" pour le chocolat,"+ORANGE+" pour un jus d'orange, "+MESSAGECUSTOMER+" pour  écrire un message");
			String choix=scan.nextLine();
			if(!choix.contains(COFFEE) && !choix.contains(TEA) && !choix.contains(CHOCOLATE) && !choix.contains(MESSAGECUSTOMER)&& !choix.contains(ORANGE))
			{
				System.out.println("Veuillez reprendre svp, l'instruction saisie ne correspond pas");
			}
			if(choix.contains(MESSAGECUSTOMER))
			{
				buildAndShowCustomerMessage();

			}
			if(choix.contains(ORANGE))
			{
				System.out.println("Veuillez entrez le montant de votre jus d' orange 0.6euros");
				Double amountDrink = null;
				try {
					amountDrink=scan.nextDouble();
				}catch(Exception e)
				{
					System.out.println(e.getMessage());
				}

				if(!checkAmountCorrect(returnDrinkJuice(choix), amountDrink))
				{
					writeRemaining(returnDrinkJuice(choix), amountDrink);
				}
				else
				{
					drinkMaker(drinkMakerProtocol(makeOrderJuice(choix)));
				}

				showCommandCustomer(output);
			}
			if(choix.contains(COFFEE) ||choix.contains(TEA)||choix.contains(CHOCOLATE))
			{

				System.out.println("Veuillez tapez la quantité de sucre que vous désirez.");
				Integer choixSucre =scan.nextInt();
				scan.nextLine();
				System.out.println("Désirez vous une boisson chaude, tapez true ou false?");
				Boolean extraHot=scan.nextBoolean();
				scan.nextLine();
				System.out.println("Veuillez entrez le montant de votre boisson. Tea :0,4euros, Coffee : 0,6euros, Chocolate: 0,5euros, Orange 0,6euros");
				Double amountDrink = null;
				try {
					amountDrink=scan.nextDouble();
				}catch(Exception e)
				{
					System.out.println(e.getMessage());
				}

				if(!checkAmountCorrect(returnDrinkHotorCold(choix, extraHot), amountDrink))
				{
					writeRemaining(returnDrinkHotorCold(choix, extraHot), amountDrink);
				}
				else
				{
					drinkMaker(drinkMakerProtocol(makeOrder(choix, choixSucre, extraHot)));
				}

				showCommandCustomer(output);
			}

			System.out.println("Désirez vous reprendre votre commande? si oui tapez 1 sinon tapez 2");
			int i = 0;
			try{
				i=scan.nextInt();
				scan.nextLine();
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
	private static void writeRemaining(Drink choixDrink, Double amountDrink) {
		Double remaining=remainingAmount(choixDrink, amountDrink);
		output="Il manque "+remaining+" euros au montant saisi";
	}


	private static void buildAndShowCustomerMessage() {
		System.out.println("Veuillez saisir votre message");
		Scanner scanMess=new Scanner(System.in);
		String messageToAffiche=scanMess.nextLine();
		drinkMaker(drinkMakerProtocol(makeOrderMessage(messageToAffiche)) );
		showCommandCustomer(output);
	}


	public  static Order makeOrder(String choix,Integer sugar,Boolean extraHot)

	{	
		Order orderCustomer=new Order();
		Drink drinkCustomer = returnDrinkHotorCold(choix, extraHot);
		orderCustomer.setDrink(drinkCustomer);
		orderCustomer.setNumberSugar(sugar.toString());
		if(sugar!=0)
		{
			orderCustomer.setStick("0");
		}



		return orderCustomer;
	}
	public  static Order makeOrderJuice(String choix)
	{	
		Order orderCustomer=new Order();
		Drink drinkCustomer = returnDrinkJuice(choix);
		orderCustomer.setDrink(drinkCustomer);

		return orderCustomer;
	}
	//Drink can be is hot
	public  static Drink returnDrinkHotorCold(String choix,Boolean extraHot) {
		Drink drinkCustomer = null;
		if(choix.contains(COFFEE))
		{
			Coffee coffee=new Coffee();
			if(extraHot)
			{
				coffee.setDrinkHot();
			}
			drinkCustomer=coffee;

		}
		if(choix.contains(CHOCOLATE))
		{	
			Chocolate chocolate=new Chocolate();
			if(extraHot)
			{
				chocolate.setDrinkHot();
			}
			drinkCustomer=chocolate;
		}
		if(choix.contains(TEA))
		{

			Tea tea=new Tea();
			if(extraHot)
			{
				tea.setDrinkHot();
			}
			drinkCustomer=tea;
		}

		return drinkCustomer;
	}

	public  static Drink returnDrinkJuice(String choix) 
	{
		Drink drinkCustomer = null;
		if(choix.contains(ORANGE))
		{
			drinkCustomer=new Orange();
		}
		return drinkCustomer;
	}
	public static Order makeOrderMessage(String message)
	{
		Order orderForShowMessage=new Order();
		orderForShowMessage.setMessage(message);
		return orderForShowMessage;

	}

	public static  String drinkMakerProtocol(Order order)
	{
		String message = null;
		SaverDrinkSell.saveDrinkSell(records, order);
		if(order.getMessage()!=null)
		{
			message=order.getInstructionForWithMessageForDrinkMaker();
			return message;
		}
		if(order.getStick()==null && order.getNumberSugar()==null && order.getMessage()==null)
		{
			message=order.getInstructionForOrangeDrinkMaker();
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
		if(messageProtocol.contains("O::"))
		{
			output="Drink maker will make one orange juice";

		}
		if(messageProtocol.contains("Ch::"))
		{
			output="Drink maker will make an extra hot coffee with no sugar";

		}
		if(messageProtocol.contains("Ch:1:0"))
		{
			output="Drink maker will make an extra hot coffee with 1 sugar and a stick";

		}
		if(messageProtocol.contains("Ch:2:0"))
		{
			output="Drink maker will make an extra hot coffee with 2 sugar and a stick";

		}

		if(messageProtocol.contains("Hh::"))
		{
			output="Drink maker will make an extra hot chocolate with no sugar and therefore  no stick";

		}

		if(messageProtocol.contains("Hh:1:0"))
		{
			output="Drink maker will make an extra hot chocolate with 1 sugar and 1 stick";

		}

		if(messageProtocol.contains("Hh:2:0"))
		{
			output="Drink maker will make an extra hot chocolate with 2 sugar and 1 stick";

		}

		if(messageProtocol.contains("Th::"))
		{
			output="Drink maker will make an extra hot tea with no sugar and and therefore  no stick";

		}

		if(messageProtocol.contains("Th:1:0"))
		{
			output="Drink maker will make an extra hot tea with 1 sugar and and 1 stick";

		}

		if(messageProtocol.contains("Th:2:0"))
		{
			output="Drink maker will make an extra hot tea with 2 sugar and and 1 stick";

		}
		
	}


	public static void showCommandCustomer(String output)
	{

		System.out.println("*******VOTRE COMMANDE**************");
		System.out.println("***"+ output +"****");
		System.out.println("***********************************");


	}

	public static Boolean checkAmountCorrect(Drink drinkCustomer ,Double amountInput)

	{
		Boolean correct=false;

		if(amountInput>drinkCustomer.getPrice()||amountInput.equals(drinkCustomer.getPrice()))
		{
			correct=true;
		}
		return correct;


	}

	public static Double remainingAmount(Drink drinkCustomer,Double amountInput)
	{

		return drinkCustomer.getPrice()-amountInput;

	}
	
	

}
