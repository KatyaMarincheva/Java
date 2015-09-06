package softuni.methods.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P12_CognateWords {
	
	static boolean solution = false;
    static List<String> list = new ArrayList<String>();
	static Map<String, String[]> uniqueSubsets = new HashMap<String, String[]>();
	
	public static void main( String args[] ){

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
	      String line = input.nextLine();
	      
	      getWordsList(line);

	      makeSubsets(); 

	      for (Map.Entry<String, String[]> entry : uniqueSubsets.entrySet()) {
	    	  
	    	  String key = entry.getKey();
	    	  String[] value = entry.getValue();
	    	  
			if (list.contains(key)) {
				System.out.printf("%s|%s=%s\n", value[0], value[1], key);
	            solution = true; 
			}
		}
	      
        if (!solution) {
            System.out.println("No");   

        }
	}


	private static void getWordsList(String line) {
		String pattern = "([A-Za-z]+)";
	      Pattern regex = Pattern.compile(pattern);
	      Matcher matcher = regex.matcher(line);
	      
	      while(matcher.find()) {
	    	  list.add(matcher.group(1));
	    	  }
	}
	

	public static void makeSubsets()
    {	
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				
				String key1 = String.format("%s%s", list.get(i), list.get(j));
				String[]value1 =  {list.get(i), list.get(j)};
				uniqueSubsets.put(key1, value1);
				
				String key2 = String.format("%s%s", list.get(j), list.get(i));
				String[] value2 =  {list.get(j), list.get(i)};
				uniqueSubsets.put(key2, value2);
			}
		}
    }
}