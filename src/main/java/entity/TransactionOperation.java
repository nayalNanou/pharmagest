package entity;

import java.util.Date;

public class TransactionOperation {
	private int id;
	private Date dateTransaction;
	private double totalPrice;
	private boolean hasPaid;
	
	public TransactionOperation(
		int id,
		Date dateTransaction,
		double totalPrice,
		boolean hasPaid
	) {
		this.setId(id);
		this.setDateTransaction(dateTransaction);
		this.setTotalPrice(totalPrice);
		this.setHasPaid(hasPaid);
	}
	
	public int getId() { return this.id; }
	public Date getDateTransaction() { return this.dateTransaction; }
	public double getTotalPrice() { return this.totalPrice; }
	public boolean getHasPaid() { return this.hasPaid; }
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public void setDateTransaction(Date dateTransaction)
	{
		this.dateTransaction = dateTransaction;
	}
	
	public void setTotalPrice(double totalPrice)
	{
		this.totalPrice = totalPrice;
	}
	
	public void setHasPaid(boolean hasPaid)
	{
		this.hasPaid = hasPaid;
	}
}
