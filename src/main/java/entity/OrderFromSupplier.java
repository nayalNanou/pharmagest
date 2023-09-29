package entity;

import java.util.Date;

public class OrderFromSupplier {
	private int id;
	private Medication medicine;
	private int quantityOrdered;
	private double totalPrice;
	private String status;
	private Date dateSending;
	private int quantityReceived;
	
	public OrderFromSupplier(
		int id,
		Medication medicine,
		int quantityOrdered,
		double totalPrice,
		String status,
		Date dateSending,
		int quantityReceived
	) {
		this.setId(id);
		this.setMedicine(medicine);
		this.setQuantityOrdered(quantityOrdered);
		this.setTotalPrice(totalPrice);
		this.setStatus(status);
		this.setDateSending(dateSending);
		this.setQuantityReceived(quantityReceived);
	}
	
	public int getId() { return this.id; }
	public Medication getMedicine() { return this.medicine; }
	public int getQuantityOrdered() { return this.quantityOrdered; }
	public double getTotalPrice() { return this.totalPrice; }
	public String getStatus() { return this.status; }
	public Date getDateSending() { return this.dateSending; }
	public int getQuantityReceived() { return this.quantityReceived; }
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public void setMedicine(Medication medicine)
	{
		this.medicine = medicine;
	}
	
	public void setQuantityOrdered(int quantityOrdered)
	{
		this.quantityOrdered = quantityOrdered;
	}
	
	public void setTotalPrice(double totalPrice)
	{
		this.totalPrice = totalPrice;
	}
	
	public void setStatus(String status)
	{
		this.status = status;
	}
	
	public void setDateSending(Date dateSending)
	{
		this.dateSending = dateSending;
	}
	
	public void setQuantityReceived(int quantityReceived)
	{
		this.quantityReceived = quantityReceived;
	}
}