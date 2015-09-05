import java.util.Scanner;

public class RactangleArea {
	
	public static void main(String[] args) {
		
		System.out.printf("Please enter the lengths of the rectangle's sides,  "
				+ "%sUse integer numbers: ", System.lineSeparator());
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		
		long area = a*b;
		
		System.out.printf("%sa=%d, b=%d, area = %d", System.lineSeparator(), a, b, area);
	}
}