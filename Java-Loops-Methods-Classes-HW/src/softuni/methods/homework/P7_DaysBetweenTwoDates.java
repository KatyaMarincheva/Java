package softuni.methods.homework;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class P7_DaysBetweenTwoDates {
	

	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.println("Please, enter start and end date in a day-month-year format");
		
		String first = scanner.nextLine();
		first = reformatDateInputString(first);
		
		String second = scanner.nextLine();
		second = reformatDateInputString(second);
		
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("d-M-yyyy");
			Date firstDate = dateFormat.parse(first);
			Date secondDate = dateFormat.parse(second);
			
			long daysBetweenDates = getDaysDifference(firstDate, secondDate);
			
			printResult(dateFormat, firstDate, secondDate, daysBetweenDates);
			
		} catch (DateTimeParseException | ParseException e) {
			System.out.println("You entered the date in the wrong format.");
		}	
	}

	private static void printResult(SimpleDateFormat dateFormat, Date firstDate, Date secondDate,
			long daysBetweenDates) {
		String format = "%d between %s and %s";
		String first = dateFormat.format(firstDate);
		String second = dateFormat.format(secondDate);
		System.out.printf(format, daysBetweenDates, first, second);
	}
	
	private static String reformatDateInputString(String str) {
		String textStr[] = str.split("-|\\.|,|/");
		str = String.join("-", textStr);
		
		return str;
	}
	
	public static long getDaysDifference(Date d1, Date d2) {
	    long diff = d2.getTime() - d1.getTime();
	    return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
}