package Test.projectpm;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GenericFunction {

	List<String> Patientid = new ArrayList<String>(10);
	List<String> Dob = new ArrayList<String>(10);
	List<String> PersonalIdentifier = new ArrayList<String>(10);
	List<String> AdmitDate = new ArrayList<String>(10);
		
//generate_PersonalIdentifier
	/*PersonalIdentifier  --------- 10 character and  unique for each row 
	 */
static final String AB = "abcdefghijklmnopqrstuvwxyz";
static SecureRandom rnd = new SecureRandom();
int n=0;

public List<String> generate_PersonalIdentifier(int len)
{
	   StringBuilder sb = new StringBuilder(len); 
	   while (n<10)
	   {
	   for(int i = 0; i < len; i++ ){
		      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
	   }
	   String PID =	sb.toString();
	   PersonalIdentifier.add(PID);
	   n=n+1;
	   sb.setLength(0);
	   }

	   return PersonalIdentifier;
}

//generate_Patientid
/*Patientid----------combination of number and character, >=20  character, <= 32 character,  append date and time for each of the patientid
 */
public List<String> getAlphaNumericString(int n) 
    { 
	
	List<String> PatientName = generate_PersonalIdentifier(n);
    System.out.println("***********"+PatientName+"*************");
	
    for (int p = 0; p < PatientName.size(); p++) 
    { 
     String p_name= PatientName.get(p);
    // add date and time
     String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
     String Patientid_unique = (p_name+"_"+timeStamp).toString();	
     Patientid.add(Patientid_unique);  
    }
     return Patientid;
    }


//function to generate a random date where age > 65
/*public List<String> generate_random_date() {
	
	    //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return date_dob;
	
}*/

	//public String generate_AdmitDate() {

	//}
	
}

