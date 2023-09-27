package entity;

public class MedicinePurchased {
	private int id;
	private Medicine medicine;
	private int quantity;
	private Prescription prescription;
	private TransactionOperation transactionOperation;
	
	public MedicinePurchased(
		int id,
		Medicine medicine,
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
	public Medicine getMedicine() { return this.medicine; }
	public int getQuantity() { return this.quantity; }
	public Prescription getPrescription() { return this.prescription; }
	public TransactionOperation getTransactionOperation() { return this.transactionOperation; }
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public void setMedicine(Medicine medicine)
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
