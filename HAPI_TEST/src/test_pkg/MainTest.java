package test_pkg;

import java.util.ArrayList;
import java.util.List;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.api.Bundle;


public class MainTest {

	public static void main(String [] args)
	{
	
		String add1 = "Toronto";
		String add2 = "Ontario";
		String add3 = "Canada";
		String fName = "Donald";
		String lName = "Duck";
		
		
		List<String> address = new ArrayList<String>();		
		address.add(add1);
		address.add(add2);
		address.add(add3);
		
		//create patient "Donald Duck" in Toronto, Ontario, Canada
		
		Create c = new Create();
		c.newPatientWLocation(address,fName,lName);
			
		//read operation...get number of patients in "duck" family		
		Query q = new Query();
		Bundle query_results = q.searchPatientFamily("duck");
		System.out.println("\n\n\n*******Found " + query_results.size() + " patients named 'duck'**********\n\n\n");
				
		q = new Query();
		//multivalued query with addresses
		query_results = q.searchPatientAddress(add1,add2,add3);
		System.out.println("\n\n\n*******Found " + query_results.size() + " patients in " + add1 + " " + add2 + " " + add3 + "**********\n\n\n");
		

	}
}
