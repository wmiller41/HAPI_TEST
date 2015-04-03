package HealthPortal;

import java.time.temporal.Temporal;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.api.ExtensionDt;
import ca.uhn.fhir.model.api.TemporalPrecisionEnum;
import ca.uhn.fhir.model.dstu.composite.NarrativeDt;
import ca.uhn.fhir.model.dstu.composite.ResourceReferenceDt;
import ca.uhn.fhir.model.dstu.resource.BaseResource;
import ca.uhn.fhir.model.dstu.resource.MedicationPrescription.DosageInstruction;
import ca.uhn.fhir.model.dstu.resource.Patient;
import ca.uhn.fhir.model.dstu.valueset.AdministrativeGenderCodesEnum;
import ca.uhn.fhir.rest.client.IGenericClient;
import ca.uhn.fhir.model.primitive.IdDt;
import ca.uhn.fhir.model.primitive.StringDt;
import ca.uhn.fhir.model.dstu.resource.*;


public class patientInit {
	
	FhirContext ctx;
	String serverBase = "http://fhirtest.uhn.ca/base";
	IGenericClient client;
	
public patientInit()
{
	ctx = new FhirContext();
	client = ctx.newRestfulGenericClient(serverBase);		
}
	
public void newPatientWMedicationsConditionsTests(String fName, String lName,String ID){
		
		Patient newPatient = new Patient();
		
		//PATIENT INFO
		newPatient.addIdentifier().setSystem("urn:fake:mrns").setValue(ID);
		newPatient.addName().addFamily(lName).addGiven(fName);
		newPatient.setGender(AdministrativeGenderCodesEnum.M);
		
		
		//PRESCRIPTION
		MedicationPrescription mp = new MedicationPrescription();
		mp.setDateWritten(new Date(),TemporalPrecisionEnum.MILLI);
		mp.setMedication(new ResourceReferenceDt().setDisplay("MEDICATION NAME?"));
		//PRESCRIPTION DOSAGE
		MedicationPrescription.DosageInstruction dosage = new MedicationPrescription.DosageInstruction();
		
		
		List<MedicationPrescription.DosageInstruction> list = new ArrayList<DosageInstruction>();
		list.add(dosage);		
		mp.setDosageInstruction(list);
		//ADD PRESCRIPTION??
		//mp.setPatient(new ResourceReferenceDt(newPatient));
		mp.setPatient(new ResourceReferenceDt("18470"));
		
		
		
		
		//MedicationDispense md = new MedicationDispense();
		//md.addDispense().setType(MedicationDispenseType.)
		//md.addDispense().setDosage(null);
		
		
		
		
	
		
		
		//for(String add : address ){
			//newPatient.addAddress().addLine(add);	
		//}
		
		client
		   .create()
		   .resource(newPatient)
		   .prettyPrint()
		   .encodedJson()
		   .execute();
		client
		   .create()
		   .resource(mp)
		   .prettyPrint()
		   .encodedJson()
		   .execute();
		
		
	}

}
