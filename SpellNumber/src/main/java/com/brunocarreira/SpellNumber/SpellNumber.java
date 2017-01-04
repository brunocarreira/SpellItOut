package com.brunocarreira.SpellNumber;
import java.util.Scanner;

/**
* Write a number between 0 and 1 billion into words.
* @author Bruno Carreira
**/
public class SpellNumber {

	private static final String[] lessTwenty = {
	   "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
	   "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

	private static final String[] tens = {
	   "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

	private static final String[] high = {"thousand", "million", "billion"};

	/**
	* Write a number between 0 and 1 billion into words.
	* I go through the number 3 by 3 (dividing by 1000), starting with the 3 less significant
	* @author Bruno Carreira
	**/
	public String spellItOut(int number) {
		if (number > 1000000000)
			return "Write a number between 0 and 1 billion";
		if (number < 1000) {
			return spellHundreds(number); }
	   StringBuilder sbResult = new StringBuilder();
	   int hundreds, thousandIndex = 0;
	   while (number > 0) {
		   hundreds = number%1000;
		  if (hundreds != 0) {
		     StringBuilder sbHundreds = new StringBuilder(spellHundreds(hundreds));
		     if (thousandIndex > 0)
		    	 sbHundreds.append(" ").append(high[thousandIndex-1]);
		     if (sbResult.length()==0)
		    	 sbResult.append(sbHundreds);
		      else
		    	 sbResult.insert(0, sbHundreds.append(" "));
		  }
		  number /= 1000;
		  thousandIndex++;
		}
	   return sbResult.toString();
	}

	// Write hundreds part (0 - 999).
	private String spellHundreds(int number) {
		int hundred = (number/100);
		int tens = (number%100);
	   StringBuilder sbHundred = new StringBuilder(lessTwenty[hundred]).append(" hundred");
	   String sTens = spellTens(tens);
	   if (hundred==0)
	      return sTens;
	   else if (tens==0)
	      return sbHundred.toString();
	   else
	      return sbHundred.append(" ").append(sTens).toString();
	}

	// Write tens part (0 - 99).
	private String spellTens (int number) {
	   if (number < 20)
	      return lessTwenty[number];
	   StringBuilder sb = new StringBuilder(tens[(number/10) - 2]);
	   if ((number%10) == 0)
	      return sb.toString();
	   return sb.append("-").append(lessTwenty[number%10]).toString(); 
	}
	
    // Main method with a console to request the number
	public static void main(String[] args) {
		SpellNumber spellNumber= new SpellNumber();
		Scanner scanner = new Scanner(System.in);
		int n = 0;
		while(n!=-1){
			System.out.println("Give me a number ");
			if (scanner.hasNextInt()){
				n = scanner.nextInt();
				System.out.println(spellNumber.spellItOut(n));
			}
			else{ 
				System.out.println("Invalid number!");
				scanner.next();
			}
			
		}
		scanner.close();
	}

}
