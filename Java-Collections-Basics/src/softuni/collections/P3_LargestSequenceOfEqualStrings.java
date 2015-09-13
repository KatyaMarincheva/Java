package softuni.collections;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P3_LargestSequenceOfEqualStrings {
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please, enter the strings on a single line separated by a space:");		
		String[] strings = sc.nextLine().split(" ");
        
        String sequence = Arrays.stream(strings)
        		.collect(Collectors.groupingBy(s -> s))
        		.entrySet()
        		.stream()
        		.max((entry1, entry2) -> entry1.getValue().size() > entry2.getValue().size() ? 1 : -1)
        		.get()
        		.getValue()
        		.stream()
                .map(i -> i.toString())
                .collect(Collectors.joining(" "));

        System.out.println(sequence);
	}
}