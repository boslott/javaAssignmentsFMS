package exampleOneTwoThree;

import java.util.*;
import java.text.DecimalFormat;

public class ConvertMe {

  // A method to determine the unit of measurement the user wants to convert FROM
  static int determineConvertFrom(Scanner cin)
  {
    System.out.println("Type the number to choose what you are converting from: \n");
		System.out.println("1) Fluid Ounces");
		System.out.println("2) Gallons");
		System.out.println("3) Ounces");
		System.out.println("4) Pounds");
		System.out.println("5) Inches");
		System.out.println("6) Feet");
		System.out.println("7) Miles");
		System.out.println("\n");
		int tmp = cin.nextInt();
    return tmp;
  }

  // A method to determine if the user inputted a valid choice for convert-from ( 1-7 )
  static boolean convertFromIsValid(int convertFrom)
  {
    if(convertFrom > 0 && convertFrom < 8)
    {
      return true;
    }
    else
    {
      return false;
    }
  }

  // A method to determine if the user inputted a valid choice for convert-to ( 1-8 )
  static boolean convertToIsValid(int convertTo)
  {
    if(convertTo > 0 && convertTo < 9)
    {
      return true;
    }
    else
    {
      return false;
    }
  }

  // A method to determine the unit of liquid measurement the user would like to convert TO
  static int determineConvertToLiquid(Scanner cin)
  {
    System.out.println("Type the number to choose what you are converting to: \n");
    System.out.println("1) Milliliters");
    System.out.println("2) Liters");
    System.out.println("\n");
    int tmp = cin.nextInt();
    return tmp;
  }
  // A method to determine the unit of solid measurement the user would like to convert TO
  static int determineConvertToSolid(Scanner cin)
  {
    System.out.println("Type the number to choose what you are converting to: \n");
    System.out.println("3) Grams");
    System.out.println("4) Kilograms");
    System.out.println("\n");
    int tmp = cin.nextInt();
    return tmp;
  }

  // A method to determine the unit of distance measurement the user would like to convert TO
  static int determineConvertToDistance(Scanner cin)
  {
    System.out.println("Type the number to choose what you want to convert to: \n");
    System.out.println("5) Millimeters");
    System.out.println("6) Centimeters");
    System.out.println("7) Meters");
    System.out.println("8) Kilometers");
    System.out.println("\n");
    int tmp = cin.nextInt();
    return tmp;
  }

/*
   A method to convert from English unit to Metric unit - liquids
    ConvertFrom == 1:  Fluid ounces
    ConvertFrom == 2:  Gallons
    ConvertTo == 1:  Milliliters
    ConverTo == 2:   Liters
*/
  static double convertLiquid(double amount, int convertFrom, int convertTo)
  {
    double tmp = 0.0;
    // floz -> milliliters
    if(convertFrom == 1 && convertTo == 1)
    {
      tmp = amount * 29.57;
    }
    // floz -> liters
    else if(convertFrom == 1 && convertTo == 2)
    {
      tmp = amount * 0.02957;
    }
    // gal -> mL
    else if(convertFrom == 2 && convertTo == 1)
    {
      tmp = amount * 3785.41;
    }
    // gal -> L
    else if(convertFrom == 2 && convertTo == 2)
    {
      tmp = amount * 3.785;
    }
    return tmp;
  }


/*
   A method to convert from English unit to Metric unit - solids
    ConvertFrom == 3:   Ounces
    ConvertFrom == 4:   Pounds
    ConvertTo == 3:     Grams
    ConvertTo == 4:     Kilograms
*/
  static double convertSolid(double amount, int convertFrom, int convertTo)
  {
    double tmp = 0.0;
    // oz -> grams
    if(convertFrom == 3 && convertTo == 3)
    {
      tmp = amount * 28.35;
    }
    // oz -> kilograms
    else if(convertFrom == 3 && convertTo == 4)
    {
      tmp = amount * 0.02835;
    }
    // lbs -> grams
    else if(convertFrom == 4 && convertTo == 3)
    {
      tmp = amount * 453.59;
    }
    // lbs -> kg
    else if(convertFrom == 4 && convertTo == 4)
    {
      tmp = amount * 0.45359;
    }
    return tmp;
  }

/*
   A method to convert from English unit to Metric unit - distance
    ConvertFrom == 5: Inches	  ConvertTo == 5: Millimeters
    ConvertFrom == 6: Feet	    ConvertTo == 6	Centimeters
    ConvertFrom == 7: Miles	    ConvertTo == 7	Meters
                            	  ConvertTo == 8	Kilometers
*/
  static double convertDistance(double amount, int convertFrom, int convertTo)
  {
    double tmp = 0.0;
    // in -> ...
    if(convertFrom == 5)
    {
      switch(convertTo) {
        // ... mm
        case 5:
          tmp = amount * 25.4;
          break;
        // ... cm
        case 6:
          tmp = amount * 2.54;
          break;
        // ... m
        case 7:
          tmp = amount * 0.0254;
          break;
        // ... km
        case 8:
          tmp = amount * 0.0000254;
          break;
        default:
          tmp = amount;
          break;
      }
    }
    // ft -> ...
    else if(convertFrom == 6)
    {
      switch(convertTo) {
        // ... mm
        case 5:
          tmp = amount * 304.8;
          break;
        // ... cm
        case 6:
          tmp = amount * 30.48;
          break;
        // ... m
        case 7:
          tmp = amount * 0.3048;
          break;
        // ... km
        case 8:
          tmp = amount * 0.0003048;
          break;
        default:
          tmp = amount;
          break;
      }
    }
    // miles -> ...
    else if(convertFrom == 7)
    {
      switch(convertTo) {
        // ... mm
        case 5:
          tmp = amount * 160900000;
          break;
        // ... cm
        case 6:
          tmp = amount * 160900;
          break;
        // ... m
        case 7:
          tmp = amount * 1609;
          break;
        // ... km
        case 8:
          tmp = amount * 1.609;
          break;
        default:
          tmp = amount;
          break;
      }
    }
    return tmp;
  }

/*
  A method to compile all conversion options and choose the appropritate one
*/
  static double computeConversion(double amount, int convertFrom, int convertTo)
  {
    double converted = 0.0;
    // Liquid conversion
    if(convertFrom < 3)
    {
      converted = convertLiquid(amount, convertFrom, convertTo);
    }
    // Solid conversion
    else if(convertFrom < 5)
    {
      converted = convertSolid(amount, convertFrom, convertTo);
    }
    // Distance conversion
    else
    {
      converted = convertDistance(amount, convertFrom, convertTo);
    }
    return converted;
  }






	public static void main(String[] args)
  {
    
		Scanner cin = new Scanner(System.in); // Scanner object to accept user input and store as variables
		double amount = 0;                    // The amount to convert
		int convertFrom = 0;                  // The unit of measurement to convert FROM
		int convertTo = 0;                    // The unit of measurement to convert TO
    double converted = 0.0;               // The completed conversion value
    // Object to round decimal points if needed
    DecimalFormat df = new DecimalFormat("#.###");
    // The convert-from options - string form
    String[] fromOptions = {"Fluid Ounces", "Gallons", "Ounces", "Pounds", "Inches", "Feet", "Miles"};
    // The convert-to options, string form
    String[] toOptions = {"Milliliters", "Liters", "Grams", "Kilograms", "Millimeters", "Centimeters", "Meters", "Kilometers"};
		
    // Prompt the user for the conversion amount and assign the input to a variable, amount
		System.out.println("Enter the amount you would like to convert: ");
		amount = cin.nextDouble();
		
    // Determine the unit of measurement to convert FROM and assign to a variable, convertFrom
    convertFrom = determineConvertFrom(cin);

    // Validate the user input
    // If valid, proceed to determine the unit of measurement to convert TO and assign to a variable, convertTo
    if(convertFromIsValid(convertFrom))
    {
      // convertFrom: floz or gal (liquids)
      if(convertFrom > 0 && convertFrom < 3)
      {
        //  Prompt user to choose milliliters or liters and assign value to variable, convertTo
        convertTo = determineConvertToLiquid(cin);
        // Validate user input 
        // If not valid, default to convertTo = 2 (liters)
        if(!convertToIsValid(convertTo))
        {
          System.out.println("Your choice was not an option. Your choice is defaulted to: Liters");
          convertTo = 2;
        }
      }
      // convertFrom: oz or lbs (solids)
      else if(convertFrom > 2 && convertFrom < 5)
      {
        // Prompt user to choose grams or kg and assign value to a variable, convertTo
        convertTo = determineConvertToSolid(cin);
        // Validate user input
        // If not valid, default to convertTo = 2 (kg)
        if(!convertToIsValid(convertTo))
        {
          System.out.println("Your choice was not an option. Your choice is defaulted to: Kilograms");
          convertTo = 2;
        }
      }
      // convertFrom: in, ft, or mi (distance)
      else if(convertFrom > 4 && convertFrom < 8)
      {
        // Prompt user to choose millimeters, centimeters, meters, or kilometers and assign to a variable, convertTo
        convertTo = determineConvertToDistance(cin);
        // Validate user input
        //If not valid, default to convertTo = 3 (meters)
        if(!convertToIsValid(convertTo))
        {
          System.out.println("Your choice was not an option. Your choice is defaulted to: Meters");
          convertTo = 3;
        }
      }
    }
    // Else, if input is not valid, default to convertFrom = 2 (Gallons) and proceed ...
    else
    {
      System.out.println("That is an incorrect choice. Your choice will default to Gallons.\n");
      convertFrom = 2;
      // Determine the unit of measurement to convert TO and assign to a variable, convertTo
      convertTo = determineConvertToLiquid(cin);
      // Validate user input
      // If not valid, default convertTo = 2 (Liters)
      if(!convertToIsValid(convertTo))
        {
          System.out.println("Your choice was not an option. Your choice is defaulted to: Liters");
          convertTo = 2;
        }
    }

    System.out.println("\nYou have chosen to convert " + amount + " " + fromOptions[convertFrom - 1] + " into " + toOptions[convertTo - 1] + "\n");
    
		// Compute the conversion
    converted = computeConversion(amount, convertFrom, convertTo);

    // Print the conversion to the screen
    System.out.println(amount + " " + fromOptions[convertFrom - 1] + " is equal to " + df.format(converted) + " " + toOptions[convertTo - 1] + "\n");

    // Thank you for using
    System.out.println("\nThank you for using this conversion app!\n");
		
		
		cin.close();
	}

  

}
