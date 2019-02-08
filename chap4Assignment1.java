package exampleOneTwoThree;

import java.util.Scanner;

public class Chap4Assignment1 {

  static int findLargest(int[] randos)
  {
    int tempMax = 0;
    
    // Loop through our array of random numbers and compare them to determine the largest integer
    for(int i = 0; i < randos.length; i++)
    {
      if(randos[i] > tempMax) 
      {
        tempMax = randos[i];
      }
    }

    return tempMax;
  }

  static void printResults(int[] randos, int max)
  {
    String tmpList = "";
    
    for(int i = 0; i < randos.length; i++)
    {
      if(i != randos.length - 1)
      {
        tmpList += randos[i] + ", ";
      }
      else
      {
        tmpList += randos[i];
      }
    }
    System.out.println("\nA list of randoms numbers was created.\n\nHere is the list: [" + tmpList + "]\n");
    System.out.println("The largest number in the list 'o randos is: " + max + "\n");
    
  }

	public static void main(String[] args) {
    
    // Declare variables
    int[] randos = new int[10];           // Declare our array of 10 items
    int max = 0;

    // Create an array of random numbers between 1 and 20
    for(int i = 0; i < 10; i++)
    {
      randos[i] = (int)((Math.random() * 20) + 1);
    }

    // Find the largest integer
    max = findLargest(randos);

    printResults(randos, max);



	}

}

