import java.util.Scanner;

public class FormattingNumbers {
	
public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please, enter an integer in the range (0<= a <= 500): ");		
		int a = input.nextInt();
		
		System.out.print("Please, enter a floating-point number b: ");		
		double b = input.nextDouble();
		
		System.out.print("Please, enter a floating-point number c: ");		
		double c = input.nextDouble();
		
		String unpaddedBinary = Integer.toBinaryString(a);
		
		String binary = String.format("%10s", unpaddedBinary).replace(' ', '0');
		
		System.out.printf("|%-10X|%s|%10.2f|%-10.3f|", a, binary, b, c);		
	}
}