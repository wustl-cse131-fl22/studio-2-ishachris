package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		
		//entering variables
		Scanner in = new Scanner(System.in);
		System.out.print("Enter Start Amount:");
		double startAmount = in.nextDouble();
		System.out.print("Enter Win Chance:");
		double winChance = in.nextDouble();
		System.out.print("Enter Win Limit:");
		double winLimit = in.nextDouble();
		System.out.print("Enter Total Simulations:");
		double totalSimulations = in.nextDouble();
		double totalAmount = startAmount;
		int day = 1;
		int numPlays = 0;
		int totalRuin = 0;
		int totalSuccess = 0;
		double a = (1-winChance)/winChance;
		
		for(; day <= totalSimulations; day++)
		{
			
			totalAmount = startAmount;
			
		//game sequence
		while (totalAmount < winLimit && totalAmount > 0)
		{
			numPlays++;
			//"score" of the game
			double random = Math.random();
			
			//game win case
			if (random < winChance)
			{
				totalAmount++;
			}
			//game lose case
			if (random > winChance)
			{
				totalAmount--;
			}
			
		}
		
		//day win case
		if (totalAmount == winLimit)
		{
			totalSuccess++;
			String result = "Success";
			System.out.println("Day " + day + ": " + result);
			System.out.println("Number of plays " + numPlays);
		}
		
		//day lose case
		if (totalAmount == 0)
		{
			totalRuin++;
			String result = "Ruin";
			System.out.println("Day " + day + ": " + result);
			System.out.println("Number of plays " + numPlays);
		}
		
		}
		
		
		
		
		
		if (day == totalSimulations);
		{
			double percent = totalRuin/day; 
			
			
			double expectedRuin = 0;
			
			if (winChance == 0.5)
			{
				expectedRuin = (1-(startAmount/winLimit));
			}
			else
			{
				expectedRuin = ((Math.pow(a, startAmount))-(Math.pow(a, winLimit)))/(1-(Math.pow(a, winLimit)));
				
			}
			System.out.println("Ruin rate: " + percent);
			System.out.println("Expected ruin rate: " + expectedRuin);
		}

	}

}
