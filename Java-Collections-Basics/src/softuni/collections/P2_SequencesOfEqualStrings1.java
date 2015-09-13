package softuni.collections;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P2_SequencesOfEqualStrings1 {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please, enter the strings on a single line separated by a space:");
		String[] array = scanner.nextLine().split(" ");
		
		Arrays.stream(array)
		.collect(Collectors.groupingBy(s -> s))
		.values()
		.stream()
		.forEach(s -> System.out.printf("%s\n", String.join(" ", s)));
	}
}