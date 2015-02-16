package test_pkg;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.api.Bundle;
import ca.uhn.fhir.model.dstu.resource.Patient;
import ca.uhn.fhir.rest.client.IGenericClient;

public class Query {
	
	
	FhirContext ctx;
	String serverBase = "http://fhirtest.uhn.ca/base";
	IGenericClient client;
		
	public Query(){
		ctx = new FhirContext();
		client = ctx.newRestfulGenericClient(serverBase);
	}
	
	
	public Bundle searchPatientFamily(String family)
	{
		// Perform a search
		Bundle results = client
		      .search()
		      .forResource(Patient.class)
		      .where(Patient.FAMILY.matches().value(family))
		      .execute();
		
		return results;		
	}
	
	
	public Bundle searchPatientAddress(String add1,String add2,String add3){
		
		Bundle results = client.search()
			      .forResource(Patient.class)
			      .where(Patient.ADDRESS.matches().values(add1))
			      .and(Patient.ADDRESS.matches().values(add2))
			      .and(Patient.ADDRESS.matches().values(add3))
			      .execute();	
		
		return results;
	}



}



