package exampleOneTwoThree;

import java.util.Scanner;

public class Chap4Assignment3 {

  static String getWord(Scanner scanner)
  {
    System.out.println("Please type your word and press enter: \n");
    return scanner.next();
  }

  static String getBackwards(char[] charArray)
  {
    String tempBackwards = "";
    for(int i = charArray.length - 1; i >= 0; i--)
    {
      tempBackwards = tempBackwards + charArray[i];
    }

    return tempBackwards;
  }

  static void printArray(char[] charArray)
  {
    String tempString = "";
    for(int i = 0; i < charArray.length; i++)
    {
      if(i != charArray.length - 1)
      {
        tempString += charArray[i] + ", ";
      }
      else
      {
        tempString += "and " + charArray[i];
      }
    }

    System.out.println("The letters in your word are: " + tempString + "\n");
  }

  static void printResults(String word, char[] charArray, String backwards)
  {
    System.out.println("\nYou entered the word: '" + word + "' \n");
    printArray(charArray);
    System.out.println("Your word backwards is: " + backwards + "\n");
  }
  {
    
    
  }

	public static void main(String[] args) {
    
    // Declare variables
    Scanner scanner = new Scanner(System.in);   // Our Scanner object to collect user input
    String word = "";                           // The word the user inputs
    char[] charArray;                           // Declare our array of characters
    String backwards;                           // Our soon-to-be backwards word
    
    word = getWord(scanner);

    charArray = word.toCharArray();
    
    backwards = getBackwards(charArray);
    

    printResults(word, charArray, backwards);



	}

}

