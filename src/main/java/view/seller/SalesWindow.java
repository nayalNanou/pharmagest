package view.seller;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

import view.utility.GenericTextField;
import dao.MedicationDao;
import entity.Medication;
import java.util.ArrayList;

public class SalesWindow {
	private JPanel panel;
	
	private JPanel leftBlock;
	private JPanel rightBlock;
	private JPanel bottomBlock;
	private GridBagConstraints leftBlockStyle;
	private GridBagConstraints rightBlockStyle;
	private GridBagConstraints bottomBlockStyle;
	
	private JPanel medicationAddedTable;
	private JButton buttonPrintReceipt;
	
	private GenericTextField medicationName;
	private GenericTextField quantity;
	private GenericTextField doctorName;
	private GenericTextField patientName;
	private JButton buttonAddMedication;
	private GridBagConstraints medicationNameStyle;
	private GridBagConstraints quantityStyle;
	private GridBagConstraints doctorNameStyle;
	private GridBagConstraints patientNameStyle;
	private GridBagConstraints buttonAddMedicationStyle;
	
	public JPanel getPanel()
	{
		return this.panel;
	}
	
	public SalesWindow() throws SQLException
	{
		this.instantiateComponents();
		this.implementLogic();
		this.styleComponents();
		this.addComponents();
	}
	
	private void instantiateComponents()
	{
		this.panel = new JPanel(new GridBagLayout());
		this.leftBlock = new JPanel(new GridBagLayout());
		this.rightBlock = new JPanel(new GridBagLayout());
		this.bottomBlock = new JPanel(new GridLayout(1, 1));
		this.medicationName = new GenericTextField("Médicament", true);
		this.quantity = new GenericTextField("Quantité", true);
		this.doctorName = new GenericTextField("Nom du médecin", true);
		this.patientName = new GenericTextField("Nom du patient", true);
		this.medicationAddedTable = new JPanel(new GridBagLayout());
		this.buttonAddMedication = new JButton("Ajouter");
		this.buttonPrintReceipt = new JButton("Imprimer le reçu");
		
		this.medicationNameStyle = new GridBagConstraints();
		this.quantityStyle = new GridBagConstraints();
		this.doctorNameStyle = new GridBagConstraints();
		this.patientNameStyle = new GridBagConstraints();
		this.buttonAddMedicationStyle = new GridBagConstraints();
		
		this.leftBlockStyle = new GridBagConstraints();
		this.rightBlockStyle = new GridBagConstraints();
		this.bottomBlockStyle = new GridBagConstraints();
	}
	
	private void implementLogic() throws SQLException
	{
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridy = 0;
		gbc.gridx = 0;
		this.medicationAddedTable.add(new JLabel("Quantité"), gbc);
		gbc.gridx = 1;
		this.medicationAddedTable.add(new JLabel("Médicament"), gbc);
		gbc.gridx = 2;
		this.medicationAddedTable.add(new JLabel("Total"), gbc);
		gbc.gridy = 1;
		gbc.gridx = 0;
		this.medicationAddedTable.add(new JLabel("Prix total :"), gbc);
	}
	
	private void styleComponents()
	{
		this.leftBlockStyle.gridy = 0;
		this.leftBlockStyle.gridx = 0;
		
		this.rightBlockStyle.gridy = 0;
		this.rightBlockStyle.gridx = 1;
		
		this.bottomBlockStyle.gridy = 1;
		this.bottomBlockStyle.gridwidth = 2;
		this.bottomBlockStyle.fill = GridBagConstraints.HORIZONTAL;
		
		this.medicationNameStyle.gridy = 0;
		this.medicationNameStyle.gridx = 0;
		this.quantityStyle.gridy = 0;
		this.quantityStyle.gridx = 1;
		this.doctorNameStyle.gridy = 1;
		this.doctorNameStyle.gridx = 0;
		this.patientNameStyle.gridy = 1;
		this.patientNameStyle.gridx = 1;
		
		this.buttonAddMedicationStyle.gridy = 2;
		this.buttonAddMedicationStyle.gridwidth = 2;
		this.buttonAddMedicationStyle.fill = GridBagConstraints.HORIZONTAL;
	}
	
	private void addComponents()
	{		
		this.leftBlock.add(this.medicationName.getPanel(), this.medicationNameStyle);
		this.leftBlock.add(this.quantity.getPanel(), this.quantityStyle);
		this.leftBlock.add(this.doctorName.getPanel(), this.doctorNameStyle);
		this.leftBlock.add(this.patientName.getPanel(), this.patientNameStyle);
		this.leftBlock.add(this.buttonAddMedication, this.buttonAddMedicationStyle);
		this.rightBlock.add(this.medicationAddedTable);
				
		this.bottomBlock.add(this.buttonPrintReceipt);
		this.panel.add(this.leftBlock, this.leftBlockStyle);
		this.panel.add(this.rightBlock, this.rightBlockStyle);
		this.panel.add(this.bottomBlock, this.bottomBlockStyle);
	}
}
