package view.pharmacist;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

import dao.MedicationDao;
import java.util.ArrayList;
import entity.Medication;
import controller.PharmacistController;

public class MedicationBelowOrderThresholdTable {
	private JPanel panel;
	private JPanel table;
	private JLabel tableTitle;
	private MedicationDao medicationDao;
	private ArrayList<Object[]> tableRows;
	private ArrayList<GridBagConstraints[]> tableRowsStyle;
	private GridBagConstraints tableStyle;
	private GridBagConstraints tableTitleStyle;
	
	public JPanel getPanel()
	{
		return this.panel;
	}
	
	public MedicationBelowOrderThresholdTable() throws SQLException
	{
		this.instantiateComponents();
		this.implementsLogic();
		this.styleComponents();
		this.addComponents();
	}
	
	private void instantiateComponents()
	{
		this.panel = new JPanel(new GridBagLayout());
		this.medicationDao = new MedicationDao();
		this.table = new JPanel(new GridBagLayout());
		this.tableTitle = new JLabel("Liste des médicaments en dessous du seuil de commande");
		this.tableRows = new ArrayList<Object[]>();
		this.tableRowsStyle = new ArrayList<GridBagConstraints[]>();
		this.tableStyle = new GridBagConstraints();
		this.tableTitleStyle = new GridBagConstraints();
	}
	
	private void implementsLogic() throws SQLException
	{
		ArrayList<Medication> listMedication = this.medicationDao.findMedicationBelowOrderThreshold();
		String[] columnNames = {
			"Médicament", "Stock", "Seuil de commande", "Stock maximum", "Catégorie", "Ordonnance",
			"Prix du fournisseur", "Fournisseur", "Action"
		};
		int listMedicationLen = listMedication.size();
		int columnNamesLen = columnNames.length;
		
		Object[] tableHeader = new Object[columnNamesLen];
		
		for (int i = 0; i < columnNamesLen; i++) {
			tableHeader[i] = new JLabel(columnNames[i]);
		}
		
		this.tableRows.add(tableHeader);
		
		for (int i = 0; i < listMedicationLen; i++) {
			Medication medication = listMedication.get(i);
			
			Object[] tableRow = new Object[columnNamesLen];

			tableRow[0] = new JLabel(medication.getName());
			tableRow[1] = new JLabel(String.valueOf(medication.getStockInHand()));
			tableRow[2] = new JLabel(String.valueOf(medication.getMinimumThresholdBeforeSupplyOrder()));
			tableRow[3] = new JLabel(String.valueOf(medication.getMaximumStock()));
			tableRow[4] = new JLabel(medication.getMedicationCategory().getName());
			tableRow[5] = new JLabel(medication.getPrescription() ? "exigé" : "non exigé");
			tableRow[6] = new JLabel(String.valueOf(medication.getSupplierPrice()));
			tableRow[7] = new JLabel(medication.getSupplier().getName());
			JButton buttonCreateOrder = new JButton("Créer la commande");
			String medicationData = String.valueOf(medication.getId()) + "@" + medication.getName() + "@" + String.valueOf(medication.getPharmacyPrice()) + "@" + medication.getPrescription() + "@" + medication.getMedicationCategory().getName() + "@" + String.valueOf(medication.getStockInHand()) + "@" + String.valueOf(medication.getMaximumStock()) + "@" + medication.getSupplier().getName() + "@" + medication.getSupplierPrice();
			buttonCreateOrder.setActionCommand(medicationData);
			buttonCreateOrder.addActionListener(PharmacistController.showOrderCreationForm);
			tableRow[8] = buttonCreateOrder;
			
			this.tableRows.add(tableRow);
		}
	}
	
	private void styleComponents()
	{
		this.tableTitleStyle.gridy = 0;
		this.tableTitleStyle.anchor = GridBagConstraints.WEST;
		this.tableStyle.gridy = 1;
		
		this.panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
		
		this.tableTitle.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		this.tableTitle.setFont(new Font("Arial", Font.PLAIN, 18));
		
		this.table.setBackground(Color.WHITE);
		this.table.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		
		int tableRowsLen = this.tableRows.size();
		
		for (int i = 0; i < tableRowsLen; i++) {
			GridBagConstraints[] tableRowStyle = new GridBagConstraints[tableRows.get(i).length];
			
			GridBagConstraints medicationNameCellStyle = new GridBagConstraints(); 
			medicationNameCellStyle.gridy = i;
			medicationNameCellStyle.gridx = 0;
			medicationNameCellStyle.anchor = GridBagConstraints.WEST;
			tableRowStyle[0] = medicationNameCellStyle;
			
			GridBagConstraints stockCellStyle = new GridBagConstraints();
			stockCellStyle.gridx = 1;
			tableRowStyle[1] = stockCellStyle;
			
			GridBagConstraints minimumThresholdBeforeSupplyOrderCellStyle = new GridBagConstraints();
			minimumThresholdBeforeSupplyOrderCellStyle.gridx = 2;
			tableRowStyle[2] = minimumThresholdBeforeSupplyOrderCellStyle;
			
			GridBagConstraints maximumStockCellStyle = new GridBagConstraints();
			maximumStockCellStyle.gridx = 3;
			tableRowStyle[3] = maximumStockCellStyle;
			
			GridBagConstraints categoryNameCellStyle = new GridBagConstraints();
			categoryNameCellStyle.gridx = 4;
			tableRowStyle[4] = categoryNameCellStyle;
			
			GridBagConstraints prescriptionCellStyle = new GridBagConstraints();
			prescriptionCellStyle.gridx = 5;
			tableRowStyle[5] = prescriptionCellStyle;
			
			GridBagConstraints supplierPriceCellStyle = new GridBagConstraints();
			supplierPriceCellStyle.gridx = 6;
			tableRowStyle[6] = supplierPriceCellStyle;
			
			GridBagConstraints supplierNameCellStyle = new GridBagConstraints();
			supplierNameCellStyle.gridx = 7;
			supplierNameCellStyle.anchor = GridBagConstraints.WEST;
			tableRowStyle[7] = supplierNameCellStyle;
			
			GridBagConstraints actionCellStyle = new GridBagConstraints();
			actionCellStyle.gridx = 8;
			tableRowStyle[8] = actionCellStyle;
			
			this.tableRowsStyle.add(tableRowStyle);
		}
		
		for (int i = 0; i < tableRowsLen; i++) {
			Object[] tableRow = this.tableRows.get(i);
			int tableRowLen = tableRow.length;
			
			for (int j = 0; j < tableRowLen; j++) {
				if (i > 0 && j == (tableRowLen - 1)) {
					JButton buttonCreateAnOrder = (JButton) tableRow[j];
					// buttonCreateAnOrder.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
				} else {
					JLabel tableCell = (JLabel) tableRow[j];
					tableCell.setBorder(BorderFactory.createEmptyBorder(6, 6, 6, 10));
				}
			}
		}
	}
	
	private void addComponents()
	{
		int tableRowsLen = this.tableRows.size();
		
		for (int i = 0; i < tableRowsLen; i++) {
			GridBagConstraints[] tableRowStyle = this.tableRowsStyle.get(i);
			Object[] tableRow = this.tableRows.get(i);
			int tableRowLen = tableRow.length;
			
			for (int j = 0; j < tableRowLen; j++) {
				if (i > 0 && j == (tableRowLen - 1)) {
					this.table.add((JButton) tableRow[j], (GridBagConstraints) tableRowStyle[j]);
				} else {
					this.table.add((JLabel) tableRow[j], (GridBagConstraints) tableRowStyle[j]);
				}
			}
		}
		
		this.panel.add(this.tableTitle, this.tableTitleStyle);
		this.panel.add(this.table, this.tableStyle);
	}
}
