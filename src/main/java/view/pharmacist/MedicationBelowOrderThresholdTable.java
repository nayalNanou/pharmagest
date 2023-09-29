package view.pharmacist;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

import dao.MedicationDao;
import java.util.ArrayList;
import entity.Medication;

public class MedicationBelowOrderThresholdTable {
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
	
	public MedicationBelowOrderThresholdTable() throws SQLException
	{
		this.instantiateComponents();
		this.implementsLogic();
		this.styleComponents();
		this.addComponents();
	}
	
	private void instantiateComponents()
	{
		this.tableTitle = new JLabel("Liste des médicaments en dessous du seuil de commande");
		this.panel = new JPanel(new GridBagLayout());
		this.medicationDao = new MedicationDao();
		this.tableTitleStyle = new GridBagConstraints();
		this.tableStyle = new GridBagConstraints();
	}
	
	private void implementsLogic() throws SQLException
	{
		ArrayList<Medication> listMedication = this.medicationDao.findMedicationBelowOrderThreshold();
		int listMedicationLen = listMedication.size();
		String[][] data = new String[listMedicationLen][8];
		String[] columnNames = {
			"Médicament",
			"Stock",
			"Seuil de commande",
			"Stock maximum",
			// "Prix", 
			"Catégorie", 
			"Ordonnance",
			"Prix du fournisseur",
			"Fournisseur"
		};
		
		for (int i = 0; i < listMedicationLen; i++) {
			Medication medication = listMedication.get(i);
		
			data[i][0] = medication.getName();
			data[i][1] = String.valueOf(medication.getStockInHand());
			data[i][2] = String.valueOf(medication.getMinimumThresholdBeforeSupplyOrder());
			data[i][3] = String.valueOf(medication.getMaximumStock());
			data[i][4] = medication.getMedicationCategory().getName();
			data[i][5] = medication.getPrescription() ? "exigé" : "non exigé";
			data[i][6] = String.valueOf(medication.getSupplierPrice());
			data[i][7] = medication.getSupplier().getName();
		}
		
		this.table = new JTable(data, columnNames);
		this.scrollPane = new JScrollPane(this.table);
	}
	
	private void styleComponents()
	{
		this.tableTitle.setFont(new Font("Arial", Font.PLAIN, 18));
		this.tableTitle.setBorder(
			BorderFactory.createEmptyBorder(20, 20, 0, 0)
		);
	
		this.table.getColumnModel().getColumn(0).setPreferredWidth(280);
		this.table.getColumnModel().getColumn(1).setPreferredWidth(90);
		this.table.getColumnModel().getColumn(2).setPreferredWidth(190);
		this.table.getColumnModel().getColumn(3).setPreferredWidth(160);
		this.table.getColumnModel().getColumn(4).setPreferredWidth(140);
		this.table.getColumnModel().getColumn(5).setPreferredWidth(160);
		this.table.getColumnModel().getColumn(6).setPreferredWidth(200);
		this.table.getColumnModel().getColumn(7).setPreferredWidth(200);
		this.scrollPane.setBorder(
			BorderFactory.createEmptyBorder(20, 20, 10, 20)
		);
	
		this.tableTitleStyle.gridx = 0;
		this.tableTitleStyle.anchor = GridBagConstraints.WEST;
		this.tableStyle.gridy = 1;
		this.tableStyle.ipadx = 550;
	}
	
	private void addComponents()
	{
		this.panel.add(this.tableTitle, this.tableTitleStyle);
		this.panel.add(this.scrollPane, this.tableStyle);
	}
}
