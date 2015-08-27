import java.util.Scanner;

public class SortArrayOfStrings {
public static void main(String[] args) {
	String[] arrayToSort = getInput();
	
	String[] sortedArray = doSelectionSort(arrayToSort);
	
	printOutput(sortedArray);
}

private static void printOutput(String[] sortedArray) {
	System.out.println();
	System.out.println("Result:");
	
	for (int i = 0; i < sortedArray.length; i++) {
		System.out.println(sortedArray[i]);
	}
}

private static String[] getInput() {
	@SuppressWarnings("resource")
	Scanner input = new Scanner(System.in);
	
	System.out.print("How many strings would you like to enter: ");		
	
	int numberOfInputs = Integer.parseInt(input.nextLine());		
	
	String[] arrayToSort = new String[numberOfInputs]; 
	
	for (int i = 0; i < numberOfInputs; i++) {
		arrayToSort[i] = input.nextLine();
	}
	return arrayToSort;
}

public static String[] doSelectionSort(String[] arr){
    
    for (int i = 0; i < arr.length - 1; i++)
    {
        int index = i;
        for (int j = i + 1; j < arr.length; j++)
            if (arr[j].compareTo(arr[index]) < 0)
                index = j;
  
        String smallerString = arr[index]; 
        arr[index] = arr[i];
        arr[i] = smallerString;
    }
    return arr;
}
}