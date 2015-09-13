package softuni.collections;

import java.util.Arrays;
import java.util.Scanner;

public class P1_SortArrayOfNumbers1 {
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please, enter the numbers on a single line separated by a space:");
		String str = scanner.nextLine();
		
		Arrays.stream(
				str.split(" "))
			    .mapToInt(Integer::parseInt)
			    .sorted()
			    .forEach(s -> System.out.printf("%s ", s));
	}
}