package Test.projectpm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* Program to generates a sample test file of patient data in CSV format 
 * that will be used as input to some automated test suites.  
 */

public class GenerateData {
		
public static void main (String[] args) throws IOException 
{
	int colCount = 4;
	List<String> Patientid = new ArrayList<String>(10);
	List<String> PersonalIdentifier = new ArrayList<String>(10);
	
	GenericFunction objGenericFunction = new GenericFunction();
	
	Patientid = objGenericFunction.getAlphaNumericString(10);
	System.out.println(Patientid);
	
	PersonalIdentifier = objGenericFunction.generate_PersonalIdentifier(10);
	System.out.println(PersonalIdentifier);
	
	WriteToFileCSV objWriteToFileCSV = new WriteToFileCSV();
	objWriteToFileCSV.PrintData(Patientid,PersonalIdentifier,colCount);
				
	}	

}
