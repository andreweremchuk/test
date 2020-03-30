import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;

public class DuplicateCounter {
	
	Map <String, String> wordCounter = new HashMap <String, String> ();
	Scanner sc;
	
	public void count (String dataFile)
	{  
	        String str1 = "";
	        String str2 = "";
	       
	        List<String> temp1 = new ArrayList<String>();      
	        ArrayList<String> temp2 = new ArrayList<String>();
	        
	        
	        try {
	             BufferedReader br = new BufferedReader(new FileReader(dataFile));
	             while (str1 != null)
	             {
	                str2 += str1;
	                str1 = br.readLine();   
	            } 
	             
	             String str[] = str2.split(" ");
	         	
	         	 temp1 = Arrays.asList(str);
	         	
	             //System.out.println(temp1);
	             
	             temp2.add(str2);
	            
	             br.close();
	             
	        } catch (Exception e) {
	            System.out.println("Error. Could not open file! Exiting program.");
	            System.exit(1);
	        }
		 
	        for (String str: temp1) {
                if (wordCounter.containsKey(str)) 
                {
                    int number = Integer.parseInt(wordCounter.get(str));
                    wordCounter.put(str, String.valueOf(number + 1));
                } 
                
                else 
                {
                    wordCounter.put(str, "1");
                }
	        }
        }

	public void write (String outputFile)
	{
		
		File fileObj = new File(outputFile);
		try {
		     
				
		      if (!fileObj.exists()) {
		    	  fileObj.createNewFile();
		      } 
				PrintWriter pw = new PrintWriter (outputFile);
		
				System.out.println("Results written to " + outputFile);
				pw.println("Word's with respective count: ");
		        pw.println(wordCounter);
		        
		        pw.close();
		        
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		      System.exit(1);
		    }
	}
	
}
