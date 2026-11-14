
package com.consoleapplications;

import java.util.Random;
import java.util.Scanner;

public class GuessRandomNumber {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random randomGenerator = new Random();
		int random = randomGenerator.nextInt(1, 11);

		for (int i = 0; i < 3; i++) {

			System.out.println("Enter number to guess:");
			int guessnum = sc.nextInt();

			if (guessnum == random) {
				System.out.println("You Win!!");
				break;

			} else if (guessnum > random) {
				System.out.println("Too High!! Try Again");

			} else if (guessnum < random) {
				System.out.println("Too Low!! Try Again");
			}

			if (i == 2 && guessnum != random) {
				System.out.println("You Lost, Better Luck Next Time");
			}
		}

		System.out.println("The correct number was: " + random);
		sc.close();
	}
}
