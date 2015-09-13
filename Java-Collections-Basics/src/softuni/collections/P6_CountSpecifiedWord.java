package softuni.collections;

import java.util.Scanner;
import java.util.regex.Pattern;

public class P6_CountSpecifiedWord {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please, enter a text.");
        String haystack = scanner.nextLine().toLowerCase();

        System.out.println("Please, enter a word.");
        String needle = scanner.nextLine();
        
		int count =  haystack.split(Pattern.quote(needle), -1).length - 1;
        System.out.println(count);
	}
}