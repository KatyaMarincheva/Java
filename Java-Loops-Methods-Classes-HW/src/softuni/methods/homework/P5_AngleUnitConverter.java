package softuni.methods.homework;

import java.util.Scanner;

public class P5_AngleUnitConverter {
	public static void main(String[] args) {
		System.out.println("Please, enter a number n, followed by n converstion queries:");
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		
		String[] convertedNumbers = new String[n];
		
		for (int i = 0; i < n; i++) {
			
			double number = input.nextDouble();
			String measuringUnit = input.next("\\w+");
			
			convertedNumbers[i]=Converter(number, measuringUnit);
		}
		
		printConvertedNumbers(convertedNumbers);
	}

	private static void printConvertedNumbers(String[] convertedNumbers) {
		for(int i=0; i<convertedNumbers.length; i++) {
			System.out.printf("%s\n", convertedNumbers[i]);
		}
	}

	private static  String Converter(double number, String measuringUnit) {
				
		if (measuringUnit.equals("deg")) {
			return degToRadConverter(number);			
		} 
		else if(measuringUnit.equals("rad")) {
			return radToDegConverter(number);
		}
		
		return "Invalid input";
	}

	private static String radToDegConverter(double number) {
		String format = "%f deg";
		double convertedNumber = Math.toDegrees(number);
		String result = String.format(format, convertedNumber);
		return  result;
	}

	private static String degToRadConverter(double number) {
		String format = "%f rad";
		double convertedNumber = Math.toRadians(number);
		String result = String.format(format, convertedNumber);
		return  result;
	}
}