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
		System.out.println("Bienvennue que d�sirez vous boire ?");
		System.out.println("Veuillez tapez 1 pour le coffee, 2 pour le th�, 3 pour le chocolat,4 pour  �crire un message");
		int choixDrink=scan.nextInt();
		scan.nextLine();
		if(choixDrink!=1 && choixDrink!=2 && choixDrink!=3 && choixDrink!=4)
		{
			System.out.println("Veuillez reprendre svp, l'instruction saisie ne correspond pas");
		}
		if(choixDrink==4)
		{
			System.out.println("Veuillez saisir votre message");
			Scanner scanMess=new Scanner(System.in);
			String messageToAffiche=scanMess.next();
			scanMess.nextLine();
			
			
		}
		if(choixDrink==1 ||choixDrink==2||choixDrink==3)
		{
			System.out.println("Veuillez tapez la quantit� de sucre que vous d�sirez");
			int choixSucre =scan.nextInt();
			
		}
		
		System.out.println("D�sirez vous reprendre votre commande? si oui tapez 1 sinon tapez 2");
		int i=scan.nextInt();
		if(i!=1)
		{
			repeatMenu=false;
		}
		
		
	}

	}
}
