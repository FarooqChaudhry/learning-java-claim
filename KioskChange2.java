package basics;

import java.util.Scanner;

/**
 * This program asks the user to input requested change which should be less than a dollar
 * It returns the most optimal change back in quarters, dimes, nickels and pennies
 */



public class KioskChange2 {
	public static void main(String[] args) {
		
		System.out.println("please request change between 1 & 99 cents");
		Scanner in = new Scanner(System.in);
		int userInput = in.nextInt();
		
		changeCalculator2(userInput);
		in.close();
		

	}
	
	public static void changeCalculator(int userInput) {
		
		int remainderAfterQuarter = userInput % 25;
//		System.out.println(remainderAfterQuarter);
		int quarters = (userInput-remainderAfterQuarter)/25;
		
		if (quarters > 0) {
			System.out.println("Quarters:" + quarters );
		}

		
		int remainderAfterDimes = remainderAfterQuarter % 10;
//		System.out.println(remainderAfterDimes);
		int dimes = (remainderAfterQuarter-remainderAfterDimes)/10;
		if (dimes > 0) {
			System.out.println("Dimes:" + dimes);
		}
		

		int remainderAfterNickels = remainderAfterDimes % 5;
//		System.out.println(remainderAfterNickels);
		int nickels = (remainderAfterDimes-remainderAfterNickels)/5;
		if (nickels > 0) {
			System.out.println("Nickels:" + nickels);
		}
		
		if (remainderAfterNickels > 0) {
			System.out.println("Pennies:" + remainderAfterNickels);
		}

		
	}
	
	public static void changeCalculator2(int userInput) {
		
		int quarters = (int) (userInput/25); 
		if (quarters > 0) {
			System.out.println("Quarters:" + quarters );
		}
		
		int dimes = (int) (userInput-(quarters*25))/10;
		if (dimes > 0) {
			System.out.println("Dimes:" + dimes);
		}
		
		int nickels= (int) ((userInput-(quarters*25)-(dimes*10))/5);
		if (nickels > 0) {
			System.out.println("Nickels:" + dimes);
		}
		
		int pennies = userInput-(quarters*25)-(dimes*10)-(nickels*5);
		if (pennies > 0) {
			System.out.println("Pennies:" + pennies);
		}
		
	}

}
