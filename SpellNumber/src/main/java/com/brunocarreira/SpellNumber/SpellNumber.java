package com.brunocarreira.SpellNumber;

/**
* Write a number between 0 and 1 billion into words.
* @author Bruno Carreira
**/
public class SpellNumber {

	private static final String[] LESS_TWENTY = {
	   "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
	   "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

	private static final String[] TENS = {
	   "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

	private static final String[] HIGH = {"thousand", "million", "billion"};
	private static final int LIMIT = 1000000000;
	private static final String ERROR_LIMIT = "Write a number between 0 and 1 billion";
	private static final String HUNDRED_TEXT = " hundred";

	/**
	* Write a number between 0 and 1 billion into words.
	* I go through the number 3 by 3 (dividing by 1000), starting with the 3 less significant
	* @author Bruno Carreira
	**/
	public String spellItOut(int number) {
		// Business Requirement
		if (number > LIMIT)
			return ERROR_LIMIT;
		if (number < 1000) {
			return spellHundreds(number); }
	   StringBuilder sbResult = new StringBuilder();
	   int hundreds, thousandIndex = 0;
	   while (number > 0) {
		   hundreds = number%1000;
		  if (hundreds != 0) {
		     StringBuilder sbHundreds = new StringBuilder(spellHundreds(hundreds));
		     if (thousandIndex > 0)
		    	 sbHundreds.append(" ").append(HIGH[thousandIndex-1]);
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
	   StringBuilder sbHundred = new StringBuilder(LESS_TWENTY[hundred]).append(HUNDRED_TEXT);
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
	      return LESS_TWENTY[number];
	   StringBuilder sb = new StringBuilder(TENS[(number/10) - 2]);
	   if ((number%10) == 0)
	      return sb.toString();
	   return sb.append("-").append(LESS_TWENTY[number%10]).toString(); 
	}
	


}
