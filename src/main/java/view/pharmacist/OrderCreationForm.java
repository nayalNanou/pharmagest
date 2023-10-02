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
	
	public void updateFormData(int idSelectedMedication)
	{
		this.refreshPanel();
	
		System.out.println("Id selected medication : " + idSelectedMedication);
		
		this.medicationName = new GenericTextField("Médicament", String.valueOf(Math.random()));
		
		this.addComponents();
	}
	
	private void refreshPanel() {
		panel.removeAll();
		panel.revalidate();
		panel.repaint();
	}
}
