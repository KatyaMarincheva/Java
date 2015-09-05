package softuni.methods.homework;

import java.util.Scanner;

public class P2_GenerateThreeLetterWords {
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please, enter a string of chars: ");
		String inputString = input.nextLine().trim().toLowerCase();
		
		char[] letters = inputString.toCharArray();
		
		System.out.printf("%sResult:%s", System.lineSeparator(), System.lineSeparator());
		
		for (int ch1 = 0; ch1 < letters.length; ch1++) {
			for (int ch2 = 0; ch2 < letters.length; ch2++) {
				for (int ch3 = 0; ch3 < letters.length; ch3++) {
					System.out.printf("%c%c%c ", letters[ch1], letters[ch2], letters[ch3]);
				}
			}
		}		
	}
}