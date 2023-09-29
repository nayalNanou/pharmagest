package entity;

public class MedicationPurchased {
	private int id;
	private Medication medicine;
	private int quantity;
	private Prescription prescription;
	private TransactionOperation transactionOperation;
	
	public MedicationPurchased(
		int id,
		Medication medicine,
		int quantity,
		Prescription prescription,
		TransactionOperation transactionOperation
	) {
		this.setId(id);
		this.setMedicine(medicine);
		this.setQuantity(quantity);
		this.setPrescription(prescription);
		this.setTransactionOperation(transactionOperation);
	}
	
	public int getId() { return this.id; }
	public Medication getMedicine() { return this.medicine; }
	public int getQuantity() { return this.quantity; }
	public Prescription getPrescription() { return this.prescription; }
	public TransactionOperation getTransactionOperation() { return this.transactionOperation; }
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public void setMedicine(Medication medicine)
	{
		this.medicine = medicine;
	}
	
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	
	public void setPrescription(Prescription prescription)
	{
		this.prescription = prescription;
	}
	
	public void setTransactionOperation(TransactionOperation transactionOperation)
	{
		this.transactionOperation = transactionOperation;
	}
}
