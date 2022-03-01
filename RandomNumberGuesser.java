/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: Let's play a game to guess a number between 0 and 99
 * Due: 2/28/2021
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: B. Leigh Vining
 */

import java.util.Scanner;

public class RandomNumberGuesser extends RNG {

	static Scanner input = new Scanner(System.in); //input from user to hold guess/int
	static Scanner keyboard = new Scanner(System.in); //input from user to hold string
	static String repeat; //variable to hold string
	static int guess, random; //variables to hold user input, random number from RNG
	static int lowGuess = 0;
	static int highGuess = 100;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		do { //do this atleast once
			resetCount(); //reset count if repeated
			lowGuess = 0;
			highGuess = 100;
			random = rand(); //call rand from RNG to get random number

			System.out.println("Enter your first guess: ");

			rangeOut(); //call method below

			System.out.println("Congratulations, you guessed correcly!");
			System.out.println("Try again? (yes or no)");
			repeat = keyboard.nextLine(); //get answer for try again
			System.out.println(""); //to keep things neat

		} while (repeat.equals("yes") || repeat.equals("Yes")); //string has to equal actual yes/Yes

			System.out.println("Thanks for playing...");
		System.out.println("Programmed by B. Leigh Vining");
	}

	static void rangeOut() {
		guess = input.nextInt(); //get user's guess
		
		//while guess is not correct
		while (guess != random) { 

			inputValidation(guess, lowGuess, highGuess); //get inputValidation from RNG

			if (guess < random && guess > lowGuess) //if guess is too low
			{
				lowGuess = guess; //create new low range with guess
				System.out.println("Your guess is too low!");
			}
			else if (guess > random && guess < highGuess) //if guess is too high
			{
				highGuess = guess; //create new high range with guess
				System.out.println("Your guess is too high!");
			}

			System.out.println("Number of guesses is " + getCount()); //call getCount method from RNG, display number of guesses made

			System.out.println("\nEnter your next guess between " + lowGuess + " and " + highGuess); //display new range to guess

			rangeOut(); //repeate method until guess is correct
		}
	}
}