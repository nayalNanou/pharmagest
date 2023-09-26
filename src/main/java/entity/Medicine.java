package entity;

public class Medicine {
	private int id;
	private String name;
	private double pharmacyPrice;
	private CategoryMedicine categoryMedicine;
	private boolean prescription;
	private int stockInHand;
	private int maximumStock;
	private int minimumThresholdBeforeSupplyOrder;
	private double supplierPrice;
	private Supplier supplier;
	
	public Medicine(
		int id,
		String name,
		double pharmacyPrice,
		CategoryMedicine categoryMedicine,
		boolean prescription,
		int stockInHand,
		int maximumStock,
		int minimumThresholdBeforeSupplyOrder,
		double supplierPrice,
		Supplier supplier
	) {
		this.setId(id);
		this.setName(name);
		this.setPharmacyPrice(pharmacyPrice);
		this.setCategoryMedicine(categoryMedicine);
		this.setPrescription(prescription);
		this.setStockInHand(stockInHand);
		this.setMaximumStock(maximumStock);
		this.setMinimumThresholdBeforeSupplyOrder(minimumThresholdBeforeSupplyOrder);
		this.setSupplierPrice(supplierPrice);
		this.setSupplier(supplier);
	}
	
	public int getId() { return this.id; }
	public String getName() { return this.name; }
	public double getPharmacyPrice() { return this.pharmacyPrice; }
	public CategoryMedicine getCategoryMedicine() { return this.categoryMedicine; }
	public boolean getPrescription() { return this.prescription; }
	public int getStockInHand() { return this.stockInHand; }
	public int getMaximumStock() { return this.maximumStock; }
	public int getMinimumThresholdBeforeSupplyOrder() { return this.minimumThresholdBeforeSupplyOrder; }
	public double getSupplierPrice() { return this.supplierPrice; }
	public Supplier getSupplier() { return this.supplier; }
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setPharmacyPrice(double pharmacyPrice)
	{
		this.pharmacyPrice = pharmacyPrice;
	}
	
	public void setCategoryMedicine(CategoryMedicine categoryMedicine)
	{
		this.categoryMedicine = categoryMedicine;
	}
	
	public void setPrescription(boolean prescription)
	{
		this.prescription = prescription;
	}
	
	public void setStockInHand(int stockInHand)
	{
		this.stockInHand = stockInHand;
	}
	
	public void setMaximumStock(int maximumStock)
	{
		this.maximumStock = maximumStock;
	}
	
	public void setMinimumThresholdBeforeSupplyOrder(int minimumThresholdBeforeSupplyOrder)
	{
		this.minimumThresholdBeforeSupplyOrder = minimumThresholdBeforeSupplyOrder;
	}
	
	public void setSupplierPrice(double supplierPrice) {
		this.supplierPrice = supplierPrice;
	}
	
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
}
