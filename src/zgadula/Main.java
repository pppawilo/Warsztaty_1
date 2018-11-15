package zgadula;

import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Random random = new Random();
		int randomNumber = 1 + random.nextInt(100);
		Scanner scan = new Scanner(System.in);
		boolean invalidNumber = false;
		boolean guessed = false;
		int guessedNumber = 0;

		do {
			do {
				System.out.print("Zgadnij liczbę: ");
				if (scan.hasNextInt()) {
					guessedNumber = scan.nextInt();
					invalidNumber = false;
				} else {
					scan.next();
					System.out.println("To nie jest liczba");
					invalidNumber = true;
				}
			} while (invalidNumber);
			if (guessedNumber < randomNumber) {
				System.out.println("Za mało!");
			} else if (guessedNumber > randomNumber) {
				System.out.println("Za dużo!");
			} else if (guessedNumber == randomNumber) {
				System.out.println("Zgadłeś!");
				guessed = true;
			}
		} while (!guessed);

	}
}
