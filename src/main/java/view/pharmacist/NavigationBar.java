package view.pharmacist;

import javax.swing.*;
import controller.PharmacistController;

public class NavigationBar {
	private JPanel panel;
	private JButton buttonMedicationList;
	private JButton buttonMedicationBelowOrderThreshold;
	private JButton buttonOrdersSent;
	private JButton buttonOrdersNotSent;
	
	public JPanel getPanel()
	{
		return this.panel;
	}
	
	public NavigationBar()
	{
		this.instantiateComponents();
		this.implementsLogic();
		this.styleComponents();
		this.addComponents();
	}
	
	private void instantiateComponents()
	{
		this.panel = new JPanel();
		this.buttonMedicationList = new JButton("Médicaments en stock");
		this.buttonMedicationBelowOrderThreshold = new JButton("Médicaments à réapprovisionner");
		this.buttonOrdersNotSent = new JButton("Commandes non envoyées");
		this.buttonOrdersSent = new JButton("Commandes envoyées");
	}
	
	private void implementsLogic()
	{
		this.buttonMedicationList.addActionListener(
			PharmacistController.showMedicationList
		);
		
		this.buttonMedicationBelowOrderThreshold.addActionListener(
			PharmacistController.showMedicationBelowOrderThreshold
		);
		
		this.buttonOrdersNotSent.addActionListener(
			PharmacistController.showOrdersNotSent
		);
		
		this.buttonOrdersSent.addActionListener(
			PharmacistController.showOrdersSent
		);
	}
	
	private void styleComponents()
	{
	
	}
	
	private void addComponents()
	{
		this.panel.add(this.buttonMedicationList);
		this.panel.add(this.buttonMedicationBelowOrderThreshold);
		this.panel.add(this.buttonOrdersNotSent);
		this.panel.add(this.buttonOrdersSent);
	}
}
