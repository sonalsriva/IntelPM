package Test.projectpm;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVWriter;

public class WriteToFileCSV
 {
	  
  public static void PrintData(List<String> Patientid,List<String> PersonalIdentifier,int colCount)
  { 
      // first create file object for file placed at location  
      String FILE_NAME = "PatientData.csv"; 
      File file = new File(FILE_NAME);
      //System.out.println(file.getAbsolutePath());
      
      try 
      { 
          // create FileWriter object with file as parameter 
          FileWriter outputfile = new FileWriter(file);     
          // create CSVWriter object filewriter object as parameter         
          CSVWriter writer = null;       
          writer = new CSVWriter(outputfile);
                    
          for(int row=0; row< Patientid.size(); row++)
          {
              String[] str = new String[] {Patientid.get(row)};
              //System.out.println(Patientid.get(row));
              writer.writeNext(str);  
          } 
          
       // closing writer connection 
          writer.close(); 
 
      }
      catch (IOException e) { 
          // TODO Auto-generated catch block 
          e.printStackTrace(); 
      }  
  }
  
  /*  public void PrintData(List<String> Patientid_unique) throws IOException  ------ older implementation
  {
	  
   String FILE_NAME = "PatientData.csv"; 
   File f = new File(FILE_NAME);
   System.out.println(f.getAbsolutePath());
   
   FileWriter fw = new FileWriter(FILE_NAME);
   PrintWriter out = new PrintWriter(fw);
   
   for (int k=0; k<10; k++)
   {
   for (int j=0; j<10; j++)
   {
	   out.print(Patientid_unique.get(j));
	   out.print(",");
   }
   }   
   //Flush the output to the file
   out.flush();      
   //Close the Print Writer
   out.close();   
   //Close the File Writer
   fw.close();       
   
  }*/
  
 }