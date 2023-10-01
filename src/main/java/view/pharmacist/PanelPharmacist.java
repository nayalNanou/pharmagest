package view.pharmacist;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import view.Frame;

public class PanelPharmacist {
	private JPanel panel;
	private NavigationBar navigationBar;
	private MedicationTable medicationTable;
	private MedicationBelowOrderThresholdTable medicationBelowOrderThresholdTable;
	private GridBagConstraints navigationBarStyle;
	private GridBagConstraints medicationTableStyle;
	private GridBagConstraints medicationBelowOrderThresholdTableStyle;
	
	public JPanel getPanel()
	{
		return this.panel;
	}
	
	public PanelPharmacist() throws SQLException
	{
		this.instantiateComponents();
		this.styleComponents();
		this.addComponents();
	}
	
	private void instantiateComponents() throws SQLException
	{
		this.panel = new JPanel(new GridBagLayout());
		this.medicationTable = new MedicationTable();
		this.medicationBelowOrderThresholdTable = new MedicationBelowOrderThresholdTable();
		this.navigationBar = new NavigationBar();
		this.navigationBarStyle = new GridBagConstraints();
		this.medicationTableStyle = new GridBagConstraints();
		this.medicationBelowOrderThresholdTableStyle = new GridBagConstraints();
	}
	
	private void styleComponents()
	{
		this.navigationBarStyle.gridy = 0;
		this.medicationTableStyle.gridy = 1;
		this.medicationBelowOrderThresholdTableStyle.gridy = 1;
		
		this.navigationBar.getPanel().setBorder(
			BorderFactory.createEmptyBorder(20, 0, 0, 0)
		);
	}
	
	private void addComponents()
	{
		this.panel.add(this.navigationBar.getPanel(), this.navigationBarStyle);
		this.panel.add(this.medicationTable.getPanel(), this.medicationTableStyle);
	}
	
	public void showView(String viewName)
	{
		this.refreshPanel();
		this.panel.add(this.navigationBar.getPanel(), this.navigationBarStyle);
		this.selectedView(viewName);
		Frame.resizeFrame();
	}
	
	private void selectedView(String viewName)
	{
		if (
			viewName.equals("MedicationTable")
		) {
			this.panel.add(this.medicationTable.getPanel(), this.medicationTableStyle);
		}
		else if (
			viewName.equals("MedicationBelowOrderThresholdTable")
		) {
			this.panel.add(
				this.medicationBelowOrderThresholdTable.getPanel(),
				this.medicationBelowOrderThresholdTableStyle
			);	
		}
	}
	
	private void refreshPanel() {
		panel.removeAll();
		panel.revalidate();
		panel.repaint();
	}
}
