import java.util.Scanner;

public class DecimalToHexadecimal {
	
	public static void main(String[] args) {
		
		System.out.print("Please, enter an integer number: ");
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		int number = input.nextInt();
		
		System.out.printf("In hexadecimal format, the number %d is %X.", number, number);
		
		System.out.printf("%sPlease, enter a number from any numeral system between 2 to 16: ", System.lineSeparator());
		String num = input.next();
		
		System.out.print("Please, enter a numeral system to convert From: ");
		int source = input.nextInt();
		System.out.print("Please, enter a numeral system to convert To: ");
		int destination = input.nextInt();
		
		if (source < 2 || destination < 2 || destination > 16 || source > 16)
        {
            System.out.print("Wrong input!Number should be in range [2 to 16]");
        }
        else
        {
        	int decimalValue = convertToDecimal(String.valueOf(num), source);
        	String result = convertDecimalToBase(decimalValue, destination);
        	
        	System.out.println(result);        	
        }
	}
	
    public static int convertToDecimal(String number, int baseFrom) {
    	
        int decimalNumber = 0;
        char[] numberString = number.toCharArray();
        
        for (int i = 0; i < number.length(); i++) {
        	
            if (numberString[i] > '9') {
            	decimalNumber += (numberString[i] - '7') * (int)Math.pow(baseFrom, (number.length() - 1 - i));
            }else {
            	decimalNumber += (numberString[i] - '0') * (int)Math.pow(baseFrom, (number.length() - 1 - i));
            }
        }
        
        return decimalNumber;
    }
    
    public static String convertDecimalToBase(long decimalNumber, int numeralSystem) {
    	
        StringBuilder sb = new StringBuilder();
        
        while (decimalNumber > 0) {
            long digit = decimalNumber % numeralSystem;

            if (digit >= 0 && digit <= 9) {
                sb.append((char)(digit + '0')); 
            }else {
            	sb.append((char)(digit + '7'));
            }

            decimalNumber /= numeralSystem;
        } 
        
        sb = sb.reverse(); 
        String output = sb.toString();
        return output;
    }
}	