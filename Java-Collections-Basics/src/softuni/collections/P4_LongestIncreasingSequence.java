package softuni.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P4_LongestIncreasingSequence {
	
	public static void main(String[] args) {
		
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        
        String formatted = "";
        List<Integer> numbers = 
        		Arrays.asList(scanner.nextLine()
				.split(" "))
                .stream()
                .map(x -> Integer.parseInt(x))
                .collect(Collectors.toList());

        if (numbers.size() <= 1) {
        	
        	formatted = formatList(numbers);
            System.out.println(formatted);
            System.out.printf("Longest: %s", formatted);
        }

        ArrayList<Integer> currentSequence = new ArrayList<>();
        currentSequence.add(numbers.get(0));
        ArrayList<Integer> longestSequence = new ArrayList<>(currentSequence);
        
        for (int i = 1; i <numbers.size() ; i++) {
            if (numbers.get(i) > numbers.get(i-1)) {
                currentSequence.add(numbers.get(i));
            } else {
            	formatted = formatList(currentSequence);
                System.out.println(formatted);
                currentSequence.clear();
                currentSequence.add(numbers.get(i));
            }
            
            if (currentSequence.size() > longestSequence.size()) {
                longestSequence = new ArrayList<>(currentSequence);
            }
        }
        
        formatted = formatList(currentSequence);
        System.out.println(formatted);
        formatted = formatList(longestSequence);
        System.out.printf("Longest: %s", formatted);
    }

	private static String formatList(List<Integer> numbers) {
		String formatted = numbers.stream()
		        .map(i -> i.toString())
		        .collect(Collectors.joining(" "));
		
		return formatted;	
	}
}