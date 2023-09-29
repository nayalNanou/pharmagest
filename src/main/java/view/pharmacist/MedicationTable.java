package view.pharmacist;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.sql.SQLException;

import entity.Medication;
import dao.MedicationDao;
import java.util.ArrayList;

public class MedicationTable {
	private JPanel panel;
	private JLabel tableTitle;
	private JTable table;
	private JScrollPane scrollPane;
	private MedicationDao medicationDao;
	
	private GridBagConstraints tableTitleStyle;
	private GridBagConstraints tableStyle;
	
	public JPanel getPanel()
	{
		return this.panel;
	}
	
	public MedicationTable() throws SQLException
	{
		this.instantiateComponents();
		this.implementsLogic();
		this.styleComponents();
		this.addComponents();
	}
	
	private void instantiateComponents()
	{
		this.panel = new JPanel(new GridBagLayout());
		this.tableTitle = new JLabel("Liste des médicaments en stock");
		this.medicationDao = new MedicationDao();
		this.tableStyle = new GridBagConstraints();
		this.tableTitleStyle = new GridBagConstraints();
	}
	
	private void implementsLogic() throws SQLException
	{
		ArrayList<Medication> listMedication = this.medicationDao.findAll();
		int listMedicationLen = listMedication.size();
		String[][] data = new String[listMedicationLen][9];
	
		for (int i = 0; i < listMedicationLen; i++) {
			Medication medication = listMedication.get(i);
			
			data[i][0] = medication.getName();
			data[i][1] = String.valueOf(medication.getPharmacyPrice());
			data[i][2] = medication.getMedicationCategory().getName();
			data[i][3] = medication.getPrescription() ? "Exigé" : "Non exigé";
			data[i][4] = String.valueOf(medication.getStockInHand());
			data[i][5] = String.valueOf(medication.getMaximumStock());
			data[i][6] = String.valueOf(medication.getMinimumThresholdBeforeSupplyOrder());
			data[i][7] = String.valueOf(medication.getSupplierPrice());
			data[i][8] = medication.getSupplier().getName();
		}

		String[] columnNames = {
			"Médicament", 
			"Prix", 
			"Catégorie", 
			"Ordonnance",
			"Stock",
			"Stock maximum",
			"Seuil de commande",
			"Prix du fournisseur",
			"Fournisseur"
		};
		this.table = new JTable(data, columnNames);
		this.scrollPane = new JScrollPane(this.table);
	}
	
	private void styleComponents()
	{
		this.table.getColumnModel().getColumn(0).setPreferredWidth(280);
		this.table.getColumnModel().getColumn(1).setPreferredWidth(70);
		this.table.getColumnModel().getColumn(2).setPreferredWidth(200);
		this.table.getColumnModel().getColumn(3).setPreferredWidth(160);
		this.table.getColumnModel().getColumn(4).setPreferredWidth(140);
		this.table.getColumnModel().getColumn(5).setPreferredWidth(160);
		this.table.getColumnModel().getColumn(6).setPreferredWidth(200);
		this.table.getColumnModel().getColumn(7).setPreferredWidth(200);
		this.table.getColumnModel().getColumn(8).setPreferredWidth(200);
		
		this.tableTitleStyle.gridy = 0;
		this.tableTitleStyle.anchor = GridBagConstraints.WEST;
		this.tableTitle.setBorder(
			BorderFactory.createEmptyBorder(20, 20, 10, 10)
		);
		this.tableTitle.setFont(new Font("Arial", Font.PLAIN, 18));
		
		this.tableStyle.gridy = 1;
		this.tableStyle.ipadx = 550;
		this.scrollPane.setBorder(
			BorderFactory.createEmptyBorder(0, 20, 20, 20)
		);
	}
	
	private void addComponents()
	{
		this.panel.add(this.tableTitle, this.tableTitleStyle);
		this.panel.add(this.scrollPane, this.tableStyle);
	}
}
