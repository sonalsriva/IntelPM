package Test.projectpm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/*************** Project: Remedy Partners ************************************
/* Program to generate test data: a sample test file of patient data in CSV format 
 * that will be used as input to some automated test suites.  
 */

public class GenerateData {
		
public static void main (String[] args) throws IOException 
{
	int noOfRecord = 11;
	
	/*********** Storing each column values in List ***********/
	List<String> patientid = new ArrayList<String>();
	List<String> personalIdentifier = new ArrayList<String>();
	
	List<List<String>> list = new ArrayList<List<String>>();
	List<String> dobList = new ArrayList<String>();
	List<String> admitDateList = new ArrayList<String>();
		
	GenericFunction objGenericFunction = new GenericFunction();
	
	/*********** Generate Data for each Column ***********/
	patientid = objGenericFunction.getAlphaNumericString(noOfRecord);
	personalIdentifier = objGenericFunction.randomestring(noOfRecord);

	list = objGenericFunction.getDOB(noOfRecord);
	dobList = list.get(0);
	admitDateList = list.get(1);
	
	/************ Saving Data to CSV ******************/
	WriteToFileCSV objWriteToFileCSV = new WriteToFileCSV();
	objWriteToFileCSV.PrintData(patientid,personalIdentifier,dobList,admitDateList);
	 
	}	

}
