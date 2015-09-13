package softuni.collections;

import java.util.Scanner;

public class P5_CountAllWords {
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please, enter a text.");

        int count = scanner.nextLine().trim().split("[\\W]+").length;
        System.out.println(count);
	}
}