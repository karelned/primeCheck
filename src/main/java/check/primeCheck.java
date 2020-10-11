package check;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class primeCheck {
	
	static boolean checkPrime(int n){
		if (n < 0) {
			return false;
		}
		  int i,m=0;      
		  m=n/2;      
		  if(n==0||n==1){  
			     return false;    
		  }else{  
		   for(i=2;i<=m;i++){      
		    if(n%i==0){      
		     return false;    
		    }      
		   }      
		     return true;  
		  }
		}  
	
	public static void main(String[] args) throws IOException {
		//System.out.println(checkPrime(-50));
		
		String fileName;
		
	    if(args.length == 0)
	    {
	    	fileName = "vzorek_dat.xlsx";
	    } else {
	    	fileName = args[0];
	    }
		
		File file = new File(fileName); //první argument

		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(fis);   
			
			XSSFSheet sheet = wb.getSheetAt(0);  //První list 
			Iterator<Row> itr = sheet.iterator();      
			while (itr.hasNext()) {  
				Row row = itr.next();  
				
				Cell cell = row.getCell(1); //Sloupec B
				if (cell!=null) {
					String outt = cell.getStringCellValue();
				    try
				    {
						int out = Integer.parseInt(outt.trim());
						if (checkPrime(out)) {
							System.out.print(out);  

							System.out.println();  
						}
				    }
				    catch (NumberFormatException nfe)
				    {
				        //System.out.println("Bad format");
				    }
				} else {
					System.out.println("Empty file");
					break;
				}
			} //while
			wb.close();
		} catch (FileNotFoundException e) {
		    System.out.println("File " + file + " not found " );
		}   
		
	}
}
