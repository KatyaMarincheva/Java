package softuni.collections;

import java.util.Arrays;
import java.util.Scanner;

public class P6_CountSpecifiedWord {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please, enter a text.");
        String haystack = scanner.nextLine().toLowerCase();

        System.out.println("Please, enter a word.");
        String needle = scanner.nextLine();
        
        Long count = Arrays.stream(haystack.split("[\\W]+")).filter(s -> s.equals(needle)).count();

        System.out.println(count);
	}
}