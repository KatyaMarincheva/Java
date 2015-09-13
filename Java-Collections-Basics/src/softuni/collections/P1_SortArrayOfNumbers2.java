package softuni.collections;

import java.util.Arrays;
import java.util.Scanner;

public class P1_SortArrayOfNumbers2 {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("How many numbers do you want to enter: ");
		int n = scanner.nextInt();
		
		int[] numbers = new int[n];
		
		System.out.println("Please, enter the numbers on a single line separated by a space:");
		for (int i = 0; i < n; i++) {			
			numbers[i] = scanner.nextInt();
		}
		
		Arrays.sort(numbers);
		
		for (int num : numbers) {
			System.out.printf("%d ", num);
		}
	}
}