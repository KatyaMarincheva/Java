package softuni.methods.homework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;

import com.google.common.base.Strings;

public class P9_ListOfProducts {
	
	public static void main(String[] args) throws IOException {
		
		// the program needs com.google.guava_1.6.0.jar
		// can be downloaded from here:
		//http://www.java2s.com/Code/Jar/c/Downloadcomgoogleguava160jar.htm
		// too large for the homework folder.....
		
		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		try {
			reader = new BufferedReader(new FileReader("P9_input.txt"));
			String line = reader.readLine();
			
			ArrayList<Product> productList = new ArrayList<Product>();
			
			while (!Strings.isNullOrEmpty(line)) {
				String[] splitLine = line.split(" ");
				String name = splitLine[0];
				BigDecimal price = new BigDecimal(splitLine[1]);
				Product currentProduct = new Product(name, price);	
				productList.add(currentProduct);
				line = reader.readLine();
			}
			
			Collections.sort(productList);
			
			writer = new BufferedWriter(new FileWriter("P9_output.txt"));
			
			for (Product product : productList) {
				String format = "%.2f %s\n";
				String productInfo = String.format(format, product.getPrice(), product.getName());
				writer.write(productInfo);
			}	
			
		} catch (IOException e) {
			System.out.println("Error!");
			
		} finally {
	        if(reader != null) {
	        	reader.close();
	        }
	        if(writer != null) {
	        	writer.close();
	        }
	    }
	}	
}