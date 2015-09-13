package softuni.collections;

import java.util.Scanner;

public class P2_SequencesOfEqualStrings2 {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please, enter the strings on a single line separated by a space:");
		
		String[] strings = sc.nextLine().split(" ");
		
		System.out.printf("%s ", strings[0]);
		
		for (int i = 1; i < strings.length; i++) {
			if (strings[i].equals(strings[i-1])) {
				System.out.printf("%s ", strings[i]);
			} else {
				System.out.printf("\n%s ", strings[i]);
			}
		}
	}
}