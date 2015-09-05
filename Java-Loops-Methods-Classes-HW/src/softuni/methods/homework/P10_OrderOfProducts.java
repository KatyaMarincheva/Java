package softuni.methods.homework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import com.google.common.base.Strings;

public class P10_OrderOfProducts {
	public static void main(String[] args) throws IOException {
		
		BufferedReader priceReader = null;
		BufferedReader orderReader = null;
		BufferedWriter writer = null;
		
		try {

			priceReader = new BufferedReader(new FileReader("P10_Products.txt"));
			orderReader = new BufferedReader(new FileReader("P10_Order.txt"));
			
			ArrayList<Product> priceList = getPriceList(priceReader);
			
			BigDecimal totalPrice = calculateOrderPrice(orderReader, priceList);
			
			writer = new BufferedWriter(new FileWriter("P10_output.txt"));
			
			String format = "%.1f";
			String output = String.valueOf(totalPrice);
			writer.write(totalPrice.toPlainString());
			
		} catch (IOException e) {
			System.out.println("Error!");
			
		} finally {
			
	        if(orderReader != null) {
	        	orderReader.close();
	        }
	        if(priceReader != null) {
	        	priceReader.close();
	        }
	        if(writer != null) {
	        	writer.close();
	        }
	    }
	}

	private static BigDecimal calculateOrderPrice(BufferedReader orderReader, ArrayList<Product> priceList)
			throws IOException {
		String orderEntry = orderReader.readLine();
		
		BigDecimal totalPrice = new BigDecimal(0);
		
		while (!Strings.isNullOrEmpty(orderEntry)) {
			
			String[] orderSplit = orderEntry.split(" ");
			
			for (Product priceListing : priceList) {
				if (priceListing.getName().equals(orderSplit[1])) {
					
					BigDecimal quantity = new BigDecimal(orderSplit[0]);
					BigDecimal currentPrice = (priceListing.getPrice()).multiply(quantity);
					totalPrice = totalPrice.add(currentPrice);
				}
			}
			
			orderEntry = orderReader.readLine();			
		}
		return totalPrice;
	}

	private static ArrayList<Product> getPriceList(BufferedReader priceReader) throws IOException {
		ArrayList<Product> priceList = new ArrayList<Product>();
		
		String priceEntry = priceReader.readLine();
		
		while (!Strings.isNullOrEmpty(priceEntry)) {
			
			String[] priceSplit = priceEntry.split(" ");
			Product currentEntry = new Product(priceSplit[0], new BigDecimal(priceSplit[1]));
			priceList.add(currentEntry);
			
			priceEntry = priceReader.readLine();
		}
		return priceList;
	}
}