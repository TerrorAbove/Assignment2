package com.ss.dpitcher.assign2;

import java.util.Scanner;

/**
 * 
 * @author David Pitcher
 *
 */
public class Assignment2
{
	public static void main(String[] args)
	{
		final int COMPUTER_NUMBER = (int)(Math.random() * 100) + 1;//draw a random number for the computer from 1 to 100 inclusive
		final int MAX_GUESSES = 5;
		
		Scanner scanner = new Scanner(System.in);//set up a Scanner, which will read input from the user from command line
		int numGuesses = 0;
		
		while(numGuesses < MAX_GUESSES)
		{
			System.out.print("Please guess a number from 1 to 100: ");
			String text = scanner.nextLine();
			
			int guess = 0;//set guess to a default value of zero
			
			try
			{
				guess = Integer.parseInt(text);//convert the String to int
			}
			catch(NumberFormatException nfe)
			{
				System.out.println("That is not an integer!");
			}
			
			if(guess <= 0 || guess > 100)//input validation
			{
				System.out.println("The number should be in the range 1 to 100.");
				continue;//keep going without using up a guess
			}
			
			if(Math.abs(COMPUTER_NUMBER - guess) <= 10)//check if the number is +/- 10 of our computer's number
			{
				System.out.println("You win! The correct number was "+COMPUTER_NUMBER+".");
				break;//break loop as soon as we've found a correct answer
			}
			
			numGuesses++;//increment counter
			
			if(numGuesses < MAX_GUESSES)//only send this message if we aren't out of guesses
				System.out.println("Not quite right. Keep going!");
		}
		
		if(numGuesses == MAX_GUESSES)
			System.out.println("Sorry! The correct number was "+COMPUTER_NUMBER+".");
		
		scanner.close();//release scanner resources
	}
}
