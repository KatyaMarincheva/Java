import java.util.Scanner;

public class CountEqualBitPairs {
	
	public static void main(String[] args) {
		
		System.out.print("Please, enter an integer: ");
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		int number = input.nextInt();
		String binary = Integer.toBinaryString(number);
		
		int mask = 3;
		int pairsCount = 0;
		
		while (number > 2) {
			if ((number & mask) == 3 || (number & mask) == 0) {
				pairsCount++;;
			}
			
			number >>= 1;
		}
		
		System.out.printf(
				"Binary representation: %s%sNumber of equal bits pairs: %d", 
				binary, 
				System.lineSeparator(), 
				pairsCount);
	}
}