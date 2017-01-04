package com.brunocarreira.SpellNumber;

import java.util.Scanner;

/**
 *  Main method with a console to request the number
 *
 */
public class App 
{
    public static void main( String[] args )
    {
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
