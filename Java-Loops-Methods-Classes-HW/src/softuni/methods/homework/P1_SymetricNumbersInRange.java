package softuni.methods.homework;

import java.util.Scanner;

public class P1_SymetricNumbersInRange {
	
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		System.out.print("Please, enter a start and an end value (0 <= start <= end <= 999): ");

		int start = input.nextInt();
		int end = input.nextInt();

		if (start < 0 || start > end || end > 999) {
			System.out.println("Invalid input!");
			
		} else {
			
			printSymetricNumbers(start, end);
		}		
	}

	private static void printSymetricNumbers(int start, int end) {

		for (int i = start; i <= end; i++) {
			
			String numberString = String.valueOf(i);
			int length = numberString.length();
			
			if (length == 1) {
				System.out.printf("%s ", numberString);
				
			} else if (length == 2) {
				if (numberString.charAt(0) == numberString.charAt(1)) {
					System.out.printf("%s ", numberString);					
				}
				
			} else if (length == 3) {
				if (numberString.charAt(0) == numberString.charAt(2)) {
					System.out.printf("%s ", numberString);				
				}				
			}	
		}
	}
}