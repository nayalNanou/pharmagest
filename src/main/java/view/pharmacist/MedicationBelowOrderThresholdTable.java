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
	private MedicationDao medicationDao;
	private ArrayList<JPanel> tableRows;
	
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
		this.panel = new JPanel();
		this.medicationDao = new MedicationDao();
		this.tableRows = new ArrayList<JPanel>();
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
		
		this.table = new JPanel(new GridLayout((listMedicationLen + 1), columnNamesLen));
		
		for (int i = 0; i < columnNamesLen; i++) {
			this.table.add(new JLabel(columnNames[i]));
		}
		
		for (int i = 0; i < listMedicationLen; i++) {
			Medication medication = listMedication.get(i);

			this.table.add(new JLabel(medication.getName()));
			this.table.add(new JLabel(String.valueOf(medication.getStockInHand())));
			this.table.add(new JLabel(String.valueOf(medication.getMinimumThresholdBeforeSupplyOrder())));
			this.table.add(new JLabel(String.valueOf(medication.getMaximumStock())));
			this.table.add(new JLabel(medication.getMedicationCategory().getName()));
			this.table.add(new JLabel(medication.getPrescription() ? "exigé" : "non exigé"));
			this.table.add(new JLabel(String.valueOf(medication.getSupplierPrice())));
			this.table.add(new JLabel(medication.getSupplier().getName()));
			
			JButton buttonCreateOrder = new JButton("Créer la commande");
			buttonCreateOrder.setActionCommand(String.valueOf(medication.getId()));
			buttonCreateOrder.addActionListener(PharmacistController.showOrderCreationForm);
			this.table.add(buttonCreateOrder);
		}
	}
	
	private void styleComponents()
	{
	
	}
	
	private void addComponents()
	{
		this.panel.add(this.table);
	}
	
/*	
	
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
		String[][] data = new String[listMedicationLen][9];
		String[] columnNames = {
			"Médicament",
			"Stock",
			"Seuil de commande",
			"Stock maximum",
			// "Prix", 
			"Catégorie", 
			"Ordonnance",
			"Prix du fournisseur",
			"Fournisseur",
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
*/
}
