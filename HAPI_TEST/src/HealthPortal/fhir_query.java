
package HealthPortal;

import java.awt.List;
import java.util.ArrayList;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.api.Bundle;
import ca.uhn.fhir.model.api.BundleEntry;
import ca.uhn.fhir.model.api.IResource;
import ca.uhn.fhir.model.dstu.resource.Patient;
import ca.uhn.fhir.rest.client.IGenericClient;
import ca.uhn.fhir.rest.gclient.StringClientParam;
import ca.uhn.fhir.model.dstu.resource.*;

public class fhir_query {

	FhirContext ctx;
	String defaultServerBase = "http://fhirtest.uhn.ca/base";
	IGenericClient client;
	
	private String serverName;
	private String patientID;
	
	fhir_query(String _serverName,String _patientID)
	{
		this.patientID = _patientID;
		this.serverName = _serverName;
		
		ctx = new FhirContext();
		client = ctx.newRestfulGenericClient(serverName);
	}
	fhir_query(String _patientID)
	{
		this.patientID = _patientID;
		this.serverName = this.defaultServerBase;
		
		ctx = new FhirContext();
		client = ctx.newRestfulGenericClient(serverName);
	}
	
	fhir_query()
	{
		this.patientID = "19620";
		this.serverName = this.defaultServerBase;
		
		ctx = new FhirContext();
		client = ctx.newRestfulGenericClient(serverName);
	}
	
	

	Bundle getPatient(){
		
		Bundle bundle = client.search().forResource(Patient.class)
				.where(new StringClientParam("_id").matches().value(patientID))
				.execute();
		
		return bundle;
	
	}
	
	//conditions
	Bundle getConditions()
	{
		Bundle bundle = client.search().forResource(Condition.class)
				.where(new StringClientParam("subject._id").matches().value(patientID))
				.execute();	
		
		return bundle;
	}
	
	//medication prescription
	Bundle getMedications()
	{
		Bundle bundle = client.search().forResource(MedicationPrescription.class)
				.where(new StringClientParam("patient").matches().value(patientID))
				.execute();
		
		return bundle;//.toListOfResources().toString();		
	}	
	//diagnostic report
	void getLabResults()
	{

		
		
		
		
	}
	

	
	

}
