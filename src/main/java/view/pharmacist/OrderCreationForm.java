package view.pharmacist;

import javax.swing.*;

public class OrderCreationForm {
	private JPanel panel;
	private GenericTextField medicationName;
	private GenericTextField price;
	private GenericTextField prescription;
	
	public JPanel getPanel()
	{
		return this.panel;
	}
	
	public OrderCreationForm()
	{	
		this.instantiateComponents();
		this.styleComponents();
		this.addComponents();
	}
	
	private void instantiateComponents()
	{
		this.panel = new JPanel();
		this.medicationName = new GenericTextField("Médicament", "");
		this.price = new GenericTextField("Prix unitaire", "");
		this.prescription = new GenericTextField("Ordonnance", "");
	}
	
	private void styleComponents()
	{
	
	}
	
	private void addComponents()
	{
		this.panel.add(this.medicationName.getPanel());
		this.panel.add(this.price.getPanel());
		this.panel.add(this.prescription.getPanel());
	}
	
	public void updateFormData(String medicationDataString)
	{
		this.refreshPanel();

		String[] medicationData = medicationDataString.split("@");
		
		System.out.println(medicationData[3]);
		
		int medicationId = Integer.parseInt(medicationData[0]);
		String medicationName = medicationData[1];
		String medicationPrice = medicationData[2];
		String prescription = Boolean.parseBoolean(medicationData[3]) ? "Requis" : "Non requis";
		String medicationCategory = medicationData[4];
		String medicationStock = medicationData[5];
		String medicationMaximumStock = medicationData[6];
		String medicationSupplier = medicationData[7];
		
		System.out.println(medicationDataString);
		
		this.medicationName = new GenericTextField("Médicament", medicationName);
		this.price = new GenericTextField("Prix unitaire", medicationPrice);
		this.prescription = new GenericTextField("Ordonnance", prescription);

		this.addComponents();
	}
	
	private void refreshPanel() {
		panel.removeAll();
		panel.revalidate();
		panel.repaint();
	}
}
