package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Integer> lotto = new ArrayList<>();
		for (int i = 1; i <= 49; i++) {
			lotto.add(i);
		}
		Collections.shuffle(lotto);
		List<Integer> lottoDraw = lotto.stream().limit(6).collect(Collectors.toList());
		Collections.sort(lottoDraw);
		System.out.println("Wynik losowania: " + lottoDraw);
		List<Integer> userGuesses = new ArrayList<>();
		boolean invalidNumber = false;
		int number = 0;
		for (int i = 0; i < 6; i++) {
			do {
				System.out.print("Wprowadź liczbę: ");
				if (scan.hasNextInt()) {
					number = scan.nextInt();
					invalidNumber = false;
					if ((number > 49) || (number < 1)) {
						System.out.println("Podaj liczbę z przedziału [1,49]");
						invalidNumber = true;
					}
					if (userGuesses.contains(number)) {
						System.out.println("Podaj inną liczbę");
						invalidNumber = true;
					}
				} else {
					scan.next();
					System.out.println("To nie jest liczba");
					invalidNumber = true;
				}
			} while (invalidNumber);
			userGuesses.add(number);

		}
		Collections.sort(userGuesses);
		System.out.println("Wybrałeś liczby: " + userGuesses);

		List<Integer> userGuessed = new ArrayList<>();
		int result = 0;
		for (Integer guess : userGuesses) {
			if (lottoDraw.contains(guess)) {
				result++;
				userGuessed.add(guess);
			}
		}
		if (result >= 3) {
			System.out.println("Trafiłeś: " + userGuessed);
			System.out.println("Trafiłeś tyle liczb: " + result);
			System.out.println("Wygrałeś milion");
		}
	}
}
