package entity;

import java.util.Date;

public class OrderFromSupplier {
	private int id;
	private Medication medication;
	private int quantityOrdered;
	private double totalPrice;
	private String status;
	private String dateSending;
	private int quantityReceived;
	
	public OrderFromSupplier(
		int id,
		Medication medication,
		int quantityOrdered,
		double totalPrice,
		String status,
		String dateSending,
		int quantityReceived
	) {
		this.setId(id);
		this.setMedication(medication);
		this.setQuantityOrdered(quantityOrdered);
		this.setTotalPrice(totalPrice);
		this.setStatus(status);
		this.setDateSending(dateSending);
		this.setQuantityReceived(quantityReceived);
	}
	
	public int getId() { return this.id; }
	public Medication getMedication() { return this.medication; }
	public int getQuantityOrdered() { return this.quantityOrdered; }
	public double getTotalPrice() { return this.totalPrice; }
	public String getStatus() { return this.status; }
	public String getDateSending() { return this.dateSending; }
	public int getQuantityReceived() { return this.quantityReceived; }
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public void setMedication(Medication medication)
	{
		this.medication = medication;
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
	
	public void setDateSending(String dateSending)
	{
		this.dateSending = dateSending;
	}
	
	public void setQuantityReceived(int quantityReceived)
	{
		this.quantityReceived = quantityReceived;
	}
}