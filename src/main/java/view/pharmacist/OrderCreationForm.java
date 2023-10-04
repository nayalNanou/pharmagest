package view.pharmacist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import controller.PharmacistController;
import dao.OrderFromSupplierDao;
import view.utility.GenericTextField;

public class OrderCreationForm {
	private JPanel panel;
	private JPanel topBlock;
	private JPanel bottomBlock;
	private int medicationId;
	private GenericTextField medicationName;
	private GenericTextField pharmacyPrice;
	private GenericTextField prescription;
	private GenericTextField category;
	private GenericTextField stock;
	private GenericTextField maximumStock;
	private GenericTextField supplierName;
	private GenericTextField supplierPrice;
	
	private GenericTextField quantityToOrder;
	private GenericTextField stockAfterReceipt;
	private GenericTextField totalPrice;
	private JPanel containerButtonCreateAnOrder;
	private JButton buttonCreateAnOrder;
	
	private GridBagConstraints topBlockStyle;
	private GridBagConstraints bottomBlockStyle;
	private GridBagConstraints medicationNameStyle;
	private GridBagConstraints pharmacyPriceStyle;
	private GridBagConstraints prescriptionStyle;
	private GridBagConstraints categoryStyle;
	private GridBagConstraints stockStyle;
	private GridBagConstraints maximumStockStyle;
	private GridBagConstraints supplierNameStyle;
	private GridBagConstraints supplierPriceStyle;
	
	private GridBagConstraints quantityToOrderStyle;
	private GridBagConstraints stockAfterReceiptStyle;
	private GridBagConstraints totalPriceStyle;
	private GridBagConstraints buttonCreateAndOrderStyle;
	
	public JPanel getPanel()
	{
		return this.panel;
	}
	
	public int getMedicationId()
	{
		return this.medicationId;
	}
	
	public GenericTextField getSupplierPrice()
	{
		return this.supplierPrice;
	}
	
	public GenericTextField getQuantityToOrder()
	{
		return this.quantityToOrder;
	}
	
	public GenericTextField getStock()
	{
		return this.stock;
	}
	
	public GenericTextField getMaximumStock()
	{
		return this.maximumStock;
	}
	
	public GenericTextField getStockAfterReceipt()
	{
		return this.stockAfterReceipt;
	}
	
	public GenericTextField getTotalPrice()
	{
		return this.totalPrice;
	}
	
	public OrderCreationForm()
	{	
		this.instantiateComponents();
		this.implementLogic();
		this.styleComponents();
		this.addComponents();
	}
	
	private void instantiateComponents()
	{
		this.panel = new JPanel(new GridBagLayout());
		this.topBlock = new JPanel(new GridBagLayout());
		this.bottomBlock = new JPanel(new GridBagLayout());
		this.medicationName = new GenericTextField("Médicament", false);
		this.pharmacyPrice = new GenericTextField("Prix en pharmacie (€)", false);
		this.prescription = new GenericTextField("Ordonnance", false);
		this.category = new GenericTextField("Catégorie", false);
		this.stock = new GenericTextField("Stock", false);
		this.maximumStock = new GenericTextField("Stock maximum", false);
		this.supplierName = new GenericTextField("Fournisseur", false) ;
		this.supplierPrice = new GenericTextField("Prix du fournisseur (€)", false);
		
		this.quantityToOrder = new GenericTextField("Quantité à commander", true);
		this.stockAfterReceipt = new GenericTextField("Stock après réception", false);
		this.totalPrice = new GenericTextField("Prix total (€)", false);
		this.containerButtonCreateAnOrder = new JPanel(new GridLayout(1, 1));
		this.buttonCreateAnOrder = new JButton("Créer la commande");
		
		this.topBlockStyle = new GridBagConstraints();
		this.bottomBlockStyle = new GridBagConstraints();
		this.medicationNameStyle = new GridBagConstraints();
		this.pharmacyPriceStyle = new GridBagConstraints();
		this.prescriptionStyle = new GridBagConstraints();
		this.categoryStyle = new GridBagConstraints();
		this.stockStyle = new GridBagConstraints();
		this.maximumStockStyle = new GridBagConstraints();
		this.supplierNameStyle = new GridBagConstraints();
		this.supplierPriceStyle = new GridBagConstraints();
		
		this.quantityToOrderStyle = new GridBagConstraints();
		this.stockAfterReceiptStyle = new GridBagConstraints();
		this.totalPriceStyle = new GridBagConstraints();
		this.buttonCreateAndOrderStyle = new GridBagConstraints();
	}
	
	private void implementLogic()
	{
		this.quantityToOrder.getTextField().addKeyListener(PharmacistController.calculateStockAndTotalPrice);
		this.buttonCreateAnOrder.addActionListener(PharmacistController.createAnOrder);
	}
	
	private void styleComponents()
	{
		this.topBlockStyle.gridy = 0;
		this.bottomBlockStyle.gridy = 1;
		
		this.medicationNameStyle.gridy = 0;
		this.medicationNameStyle.gridx = 0;
		this.pharmacyPriceStyle.gridy = 0;
		this.pharmacyPriceStyle.gridx = 1;
		this.prescriptionStyle.gridy = 0;
		this.prescriptionStyle.gridx = 2;
		this.categoryStyle.gridy = 1;
		this.categoryStyle.gridx = 0;
		this.stockStyle.gridy = 1;
		this.stockStyle.gridx = 1;
		this.maximumStockStyle.gridy = 1;
		this.maximumStockStyle.gridx = 2;
		this.supplierNameStyle.gridy = 2;
		this.supplierNameStyle.gridx = 0;
		this.supplierPriceStyle.gridy = 2;
		this.supplierPriceStyle.gridx = 1;
		
		this.quantityToOrderStyle.gridy = 0;
		this.quantityToOrderStyle.gridx = 0;
		this.stockAfterReceiptStyle.gridy = 0;
		this.stockAfterReceiptStyle.gridx = 1;
		this.totalPriceStyle.gridy = 0;
		this.totalPriceStyle.gridx = 2;
		this.buttonCreateAndOrderStyle.gridy = 1;
		this.buttonCreateAndOrderStyle.fill = GridBagConstraints.HORIZONTAL;
		this.buttonCreateAndOrderStyle.gridwidth = 3;
		
		this.containerButtonCreateAnOrder.setBorder(BorderFactory.createEmptyBorder(8, 4, 4, 4));
	}
	
	private void addComponents()
	{
		this.topBlock.add(this.medicationName.getPanel(), this.medicationNameStyle);
		this.topBlock.add(this.pharmacyPrice.getPanel(), this.pharmacyPriceStyle);
		this.topBlock.add(this.prescription.getPanel(), this.prescriptionStyle);
		this.topBlock.add(this.category.getPanel(), this.categoryStyle);
		this.topBlock.add(this.stock.getPanel(), this.stockStyle);
		this.topBlock.add(this.maximumStock.getPanel(), this.maximumStockStyle);
		this.topBlock.add(this.supplierName.getPanel(), this.supplierNameStyle);
		this.topBlock.add(this.supplierPrice.getPanel(), this.supplierPriceStyle);
		
		this.bottomBlock.add(this.quantityToOrder.getPanel(), this.quantityToOrderStyle);
		this.bottomBlock.add(this.stockAfterReceipt.getPanel(), this.stockAfterReceiptStyle);
		this.bottomBlock.add(this.totalPrice.getPanel(), this.totalPriceStyle);
		this.containerButtonCreateAnOrder.add(this.buttonCreateAnOrder);
		this.bottomBlock.add(this.containerButtonCreateAnOrder, this.buttonCreateAndOrderStyle);
		
		this.panel.add(this.topBlock, this.topBlockStyle);
		this.panel.add(this.bottomBlock, this.bottomBlockStyle);
	}
	
	public void updateFormData(String medicationDataString)
	{
		String[] medicationData = medicationDataString.split("@");
		
		System.out.println(medicationData[3]);
		
		this.medicationId = Integer.parseInt(medicationData[0]);
		String medicationName = medicationData[1];
		String medicationPrice = medicationData[2];
		String prescription = Boolean.parseBoolean(medicationData[3]) ? "Requis" : "Non requis";
		String medicationCategory = medicationData[4];
		String medicationStock = medicationData[5];
		String medicationMaximumStock = medicationData[6];
		String medicationSupplierName = medicationData[7];
		String medicationSupplierPrice = medicationData[8];
		
		this.medicationName.setFieldValue(medicationName);
		this.pharmacyPrice.setFieldValue(medicationPrice);
		this.prescription.setFieldValue(prescription);
		this.category.setFieldValue(medicationCategory);
		this.stock.setFieldValue(medicationStock);
		this.maximumStock.setFieldValue(medicationMaximumStock);
		this.supplierName.setFieldValue(medicationSupplierName);
		this.supplierPrice.setFieldValue(medicationSupplierPrice);
	}
	
	private void refreshPanel() {
		panel.removeAll();
		panel.revalidate();
		panel.repaint();
	}
}
