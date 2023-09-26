package entity;

import java.util.Date;

public class Prescription {
	private int id;
	private String doctorName;
	private Date datePrescription;
	private String patientName;
	
	public Prescription(
		int id,
		String doctorName,
		Date datePrescription,
		String patientName
	) {
		this.setId(id);
		this.setDoctorName(doctorName);
		this.setDatePrescription(datePrescription);
		this.setPatientName(patientName);
	}
	
	public int getId() { return this.id; }
	public String getDoctorName() { return this.doctorName; }
	public Date getDatePrescription() { return this.datePrescription; }
	public String getPatientName() { return this.patientName; }
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public void setDoctorName(String doctorName)
	{
		this.doctorName = doctorName;
	}
	
	public void setDatePrescription(Date datePrescription)
	{
		this.datePrescription = datePrescription;
	}
	
	public void setPatientName(String patientName)
	{
		this.patientName = patientName;
	}
}
