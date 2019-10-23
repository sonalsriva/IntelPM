package Test.projectpm;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVWriter;


/**********Writting Data to CSV file **************/

public class WriteToFileCSV
 {
	  
  public void PrintData(List<String> patientid,List<String> personalIdentifier,List<String> dobList,List<String> admitDateList)
  { 

      // Create file object for file placed at project location  
      String FILE_NAME = "PatientData.csv"; 
      File file = new File(FILE_NAME);
      System.out.println(file.getAbsolutePath());
      
      try 
      { 
          // create FileWriter object with file as parameter 
          FileWriter outputfile = new FileWriter(file);     
          // create CSVWriter object filewriter object as parameter         
          CSVWriter writer = null;       
          writer = new CSVWriter(outputfile);
          
          //Specify Header name in file
          int row = 0;
          String[] headerName = new String[4];
          headerName[0] = "Patientid";
          headerName[1] = "Date of Birth";
          headerName[2] = "PersonalIdentifier";
          headerName[3] = "admit date";
          writer.writeNext(headerName);
          
          //Write values in CSV
          for(row=1; row< patientid.size(); row++)
          {

              String[] str = new String[4];
              str[0] = patientid.get(row);
              str[1] = dobList.get(row);
              str[2] = personalIdentifier.get(row);
              str[3] = admitDateList.get(row);
              
              writer.writeNext(str);  
          } 
          
       // closing writer connection 
          writer.close(); 
 
      }
      catch (IOException e) { 
          e.printStackTrace(); 
      }  
  }
  
 }
