import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TheSmallestOfThreeNumbers {
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please, enter three numbers a, b and c: ");
		ArrayList<Double> numbers = new ArrayList<Double>();
		for (int i = 0; i < 3; i++) {
			numbers.add(scanner.nextDouble());
		}
			
		Double minNumber = Collections.min(numbers);
		
		System.out.println(minNumber);
	}
}