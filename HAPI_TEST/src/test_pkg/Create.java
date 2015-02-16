package test_pkg;

import java.util.List;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.api.Bundle;
import ca.uhn.fhir.model.dstu.resource.Patient;
import ca.uhn.fhir.rest.client.IGenericClient;

public class Create {
	
	
	FhirContext ctx;
	String serverBase = "http://fhirtest.uhn.ca/base";
	IGenericClient client;
	
	public Create()
	{
		ctx = new FhirContext();
		client = ctx.newRestfulGenericClient(serverBase);		
	}
		
	public void newPatientWLocation(List<String> address, String fName, String lName){
		
		Patient newPatient = new Patient();
		
		newPatient.addName().addFamily(lName).addGiven(fName);
		
		for(String add : address ){
			newPatient.addAddress().addLine(add);	
		}
		
		client
		   .create()
		   .resource(newPatient)
		   .prettyPrint()
		   .encodedJson()
		   .execute();
	}
	
	
	
	
	
	
}