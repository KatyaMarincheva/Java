import java.util.Scanner;

public class CountOfBitsOne {
	
	public static void main(String[] args) {
		
		System.out.print("Please, enter an integer number: ");
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		int number = input.nextInt();
		
		int countBits = Integer.bitCount(number);
		
		System.out.printf(
				"Binary representation: %s%sNumber of 1-bits: %d", 
				Integer.toBinaryString(number), 
				System.lineSeparator(), 
				countBits);
	}
}