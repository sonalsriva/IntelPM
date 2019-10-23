package Test.projectpm;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

/***************** Common Function File *********************/
public class GenericFunction {

	List<String> patientid = new ArrayList<String>();
	List<String> dob = new ArrayList<String>();
	List<String> personalIdentifier = new ArrayList<String>();
	List<String> admitDate = new ArrayList<String>();
		
	static SecureRandom rnd = new SecureRandom();
	int n=0;

	/************** Below Function to Generate Patientid----------combination of number and character, >=20  character, <= 32 character,  append date and time for each of the patientid
	 returns = List of Patientsname with alphanumeric_timestamp values */
	public List<String> getAlphaNumericString(int nrecords) 
	    { 
		
	    for (int n = 1; n <= nrecords; n++) 
	    { 
    
	    	String pAlpha = arandomestring();
	    	String pnum = arandomeNum();
		  	String patientName = pAlpha+pnum;
		  	String p_name = patientName;
		  	
		    // add date and time for each record
		     String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		     String patientid_unique = (p_name+"_"+timeStamp).toString();	
		     patientid.add(patientid_unique);  
	    }
	 
	     return patientid;
	    }

	/******** Below Function to Generate PersonalIdentifier --------- 10 character and  unique for each row */
	public List<String> randomestring(int nrecords) 
	{  
		int n=1;
		String generatedstring;
		List<String> patientNameRecord = new ArrayList<String>();
		while(n <= nrecords)
		{
			generatedstring =RandomStringUtils.randomAlphabetic(10); 
			patientNameRecord.add(generatedstring);
			n++;		
		}
			return(patientNameRecord); 
		}

	/*********** Below Function to generate a random alpha string ***********/
	public String arandomestring() 
	{ 
 		String generatedstring =RandomStringUtils.randomAlphabetic(8); 
 		return(generatedstring); 
 	} 

	/*********** Below Function to generate a random numeric string ***********/
	public static String arandomeNum() { 
 		String generatedString2 = RandomStringUtils.randomNumeric(4); 
 		return (generatedString2); 
 	} 
	
	/*********** Below Function to Generate random dates for ---------------- DOB and Joining_Date */
	public List<List<String>> getDOB(int nrecords) {
		
		List<List<String>> list = new ArrayList<List<String>>();		
	    GregorianCalendar gc = new GregorianCalendar();
	    int curYear = Calendar.getInstance().get(Calendar.YEAR);
	    int maxCriteria = curYear - 65;
	    Random rand = new Random(); 
	    	    
	    for(int n = 1; n <=nrecords; n++){	    	
	    /************ Admit Date *************************/	    
	    
		    Calendar cal = Calendar.getInstance();
		    int rand_int1 = rand.nextInt(99);
		    
	    	cal.add(Calendar.DAY_OF_MONTH, -rand_int1);   	
	    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    	String admitDat = formatter.format(cal.getTime());

	    /************ Birth Date *************************/	
	    	int year = randBetween(maxCriteria-35, maxCriteria);
	        gc.set(gc.YEAR, year);
	        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
	        gc.set(gc.DAY_OF_YEAR, dayOfYear);
	        String dob2 = gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH);

	        dob.add(dob2);
	        admitDate.add(admitDat);
	    }
	    
	    list.add(0,dob);
	    list.add(1,admitDate);
	    return list;
	}

	public static int randBetween(int start, int end) {
	    return start + (int)Math.round(Math.random() * (end - start));
	}

}

