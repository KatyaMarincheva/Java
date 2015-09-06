package softuni.methods.homework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.TreeMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class P11_Excel {
	public static void main(String[] args) throws IOException {
		
		// the program needs:
		// poi-3.12-20150511.jar
		// (http://www.apache.org/dyn/closer.lua/poi/release/bin/poi-bin-3.12-20150511.zip)
		// poi-ooxml-3.12.jar
		// (http://mvnrepository.com/artifact/org.apache.poi/poi-ooxml/3.12)
		// poi-ooxml-schemas-3.12.jar
		// (http://mvnrepository.com/artifact/org.apache.poi/poi-ooxml-schemas/3.12-beta1)
		// xmlbeans-2.6.0.jar
		// (http://www.java2s.com/Code/Jar/x/Downloadxmlbeans260jar.htm)
		// all too large to be submitted with the homework folder
		
        Locale.setDefault(Locale.ROOT);
        FileInputStream input = null;
        
        try {
        	
        	input = new FileInputStream("Incomes-Report.xlsx");
        	 
            @SuppressWarnings("resource")
			XSSFWorkbook wb = new XSSFWorkbook(input);
            XSSFSheet sheet = wb.getSheet("Incomes");
            
            TreeMap<String, Double> allOffices = new TreeMap<String, Double>();
            double totalIncome = 0;
           
            XSSFRow currentRow = sheet.getRow(1);
            while (currentRow != null) {
                	
	            XSSFCell officeCell = currentRow.getCell(0);
	            String currentOffice = officeCell.getStringCellValue();
	            
	            XSSFCell incomeCell = currentRow.getCell(5);
	            double currentIncome = incomeCell.getNumericCellValue(); 
	            
	            totalIncome += currentIncome;
	            
	            if (allOffices.containsKey(currentOffice)) {
	                    currentIncome += allOffices.get(currentOffice);
	            }
	            allOffices.put(currentOffice, currentIncome);
	            currentRow = sheet.getRow(1 + currentRow.getRowNum());
            }
                
            for (String office: allOffices.keySet()) {    
                	
            double income = allOffices.get(office);  
            
            String officeFormat = "%s -> %.2f\n";
            System.out.printf(officeFormat, office, income);                      
            }
                
            String totalFormat = "Grand Total -> %.2f";
            System.out.printf(totalFormat, totalIncome);
               
        } catch (IOException e) {
                e.printStackTrace();
                
        } finally {
			
	        if(input != null) {
	        	input.close();
	        }

	    }
	}
}