package softuni.methods.homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import com.google.common.base.Strings;

public class P8_SumNumbersFromFile {
	
	public static void main(String[] args) throws IOException {
		BufferedReader fileReader = null;
		
		try {
			fileReader = new BufferedReader(new FileReader("P8_input.txt"));
			
			long sum = 0;
			
			String lineContent = fileReader.readLine().trim();
			
			while (!Strings.isNullOrEmpty(lineContent)) {
				sum += Integer.parseInt(lineContent);
				lineContent = fileReader.readLine();
			};
			
			System.out.println(sum);
			
		} catch (IOException e) {
			System.out.println("Error");
			
		} finally {
	        if(fileReader != null) {
	        	fileReader.close();
	        }
	    }		
	}
}