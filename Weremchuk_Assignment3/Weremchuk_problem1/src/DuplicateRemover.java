import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.lang.String;

public class DuplicateRemover {
	
	Scanner sc;
	Set<String> uniqueWords = new HashSet<String>();
	
	public void remove (String dataFile)
	{    	 
		
		String [] allWords = new String [99999];

	    	 try {
	    		 sc = new Scanner (new File (dataFile));
	    	 }
	    	 catch(Exception e)
	    	 {
	    		 System.out.println("Could not open file.");
	    		 System.exit(1);
	    	 }
	    	 	 
    		 //System.out.println(allWords);
    		
	    	 int count = 0;
			 while (sc.hasNext())
	    	 {
				 allWords [count] = sc.next();
				 allWords[count] = allWords[count].toLowerCase();
				 //System.out.println(allWords[count]);
				 count++;	 
	    	 }
			 
			// System.out.println(allWords);
			 	 
			 for (String temp: allWords)
			 {
				uniqueWords.add(temp);
				//System.out.println(uniqueWords);
			 }
			 
			 
			 //System.out.println(count);
			 
	    	 sc.close();
	}
	
	public void write (String outputFile)
	{
		
		File fileObj = new File(outputFile);
		try {
		     
				
		      if (!fileObj.exists()) {
		    	  fileObj.createNewFile();
		      } 
		      
		        Iterator<String> itr = uniqueWords.iterator();
				PrintWriter pw = new PrintWriter (outputFile);
				
				pw.println("List of unique words: ");
				System.out.println("Results written to " + outputFile);
				
				while (itr.hasNext())
				{
					pw.print(itr.next() + " ");
					
				}
				
		        pw.close();
		        
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		      System.exit(1);
		    }
	}
	

}
