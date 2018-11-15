package zgadula;

import java.util.Scanner;

public class MainComputer {
	public static void main(String[] args) {
		System.out.println("Pomyśl liczbę od 0 do 1000, a ja zgadnę ją w maksymalnie dziesięciu próbach");
		System.out.println("Odpowiedzi: 'za dużo', 'za mało', 'zgadłeś'.");
		int min = 0;
		int max = 1000;
		boolean guessed = false;
		do {
			int guess = ((max - min) / 2) + min;

			System.out.println("Zgaduję " + guess);
			Scanner scan = new Scanner(System.in);
			String answer = scan.nextLine();
			if (answer.equals("zgadłeś")) {
				System.out.println("Wygrałem!");
				guessed = true;
			} else if (answer.equals("za dużo")) {
				max = guess;
			} else if (answer.equals("za mało")) {
				min = guess;
				if (max - min == 1) {
					min++;
				}
			} else {
				System.out.println("Nie oszukuj!");
			}
		} while (!guessed);

	}
}
