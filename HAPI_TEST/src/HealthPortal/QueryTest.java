package HealthPortal;

import java.util.ArrayList;
import java.util.List;

import ca.uhn.fhir.model.api.Bundle;
import ca.uhn.fhir.model.api.BundleEntry;
import ca.uhn.fhir.model.api.IResource;
import ca.uhn.fhir.model.base.composite.BaseContainedDt;
import ca.uhn.fhir.model.dstu.resource.Condition;
import ca.uhn.fhir.model.dstu.resource.MedicationPrescription;
import ca.uhn.fhir.model.dstu.resource.Organization;
import ca.uhn.fhir.model.dstu.resource.Patient;


public class QueryTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

				
		fhir_query fq = new fhir_query("19620");
		
		Bundle meds = fq.getMedications();
		Bundle conditions = fq.getConditions();
		Bundle patient = fq.getPatient();
		
		
		List<MedicationPrescription> list_meds = meds.getResources(MedicationPrescription.class);
		 for (MedicationPrescription mp : list_meds) {
		     System.out.println("***********Medication " + mp.getMedication().getDisplay().getValue() + " Date Written " + mp.getDateWritten().toString());
		    
		 }
		
		List<Condition> list_cond = conditions.getResources(Condition.class);
		 for (Condition c : list_cond) {
		     System.out.println("***********Medical Condition=" + c.getCode().getCoding().get(0).getDisplay());
		 }
		 

			List<Patient> list_patient = patient.getResources(Patient.class);
			 for (Patient p : list_patient) {
			     System.out.println("***********Organization=" + p.getManagingOrganization().getDisplay());
			    
			 }
		 
		
		 
	 
		
	}
	
	
	
	
		

}
