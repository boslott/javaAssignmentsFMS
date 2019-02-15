package exampleOneTwoThree;

import java.util.Scanner;
import java.util.ArrayList;

public class FactorMe {
	
	static int getInput(Scanner scanner)
	{
		System.out.println("Please input a number: ");
		return scanner.nextInt();
	}
	
	static ArrayList<Integer> getFactors(int userInput)
	{
		ArrayList<Integer> factorsList = new ArrayList<Integer>();
		
		for(int i = 1; i <= userInput; i++)
		{
			// Mod 0 is NaN and errors-out
			if(userInput % i == 0)
			{
				factorsList.add(i);
			}
		}
		
		
		return factorsList;
	}
	
	static int sumFactors(ArrayList<Integer> factorsList) {
		int sum = 0;
		
		for(int i = 0; i < factorsList.size(); i++)
		{
			sum = sum + factorsList.get(i);
		}
		
		return sum;
	}
	
	static void printResults(ArrayList<Integer> factorsList, int userInput, int sum) 
	{
		System.out.println("");
		System.out.println("You inputted the number: " + userInput + "\n");
		System.out.println("The factors of " + userInput + " are: \n");
		System.out.println(factorsList + "\n");
		System.out.println("The sum of the factors of " + userInput + " is: " + sum + "\n");
		System.out.println("Thank you for using The Factoring Factor Factory!");
	}
	

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int userInput = 0;
		ArrayList<Integer> factorsList = new ArrayList<Integer>();
		int sum = 0;
		
		userInput = getInput(scanner);
		
		factorsList = getFactors(userInput);
		
		sum = sumFactors(factorsList);

		printResults(factorsList, userInput, sum);
		
		
	}

}
