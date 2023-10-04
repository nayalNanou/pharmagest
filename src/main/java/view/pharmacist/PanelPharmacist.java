package view.pharmacist;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import view.Frame;

public class PanelPharmacist {
	private JPanel panel;
	private NavigationBar navigationBar;
	private MedicationTable medicationTable;
	private OrderCreationForm orderCreationForm;
	private MedicationBelowOrderThresholdTable medicationBelowOrderThresholdTable;
	private OrdersNotSentTable ordersNotSentTable;
	private GridBagConstraints navigationBarStyle;
	private GridBagConstraints medicationTableStyle;
	private GridBagConstraints medicationBelowOrderThresholdTableStyle;
	private GridBagConstraints ordersNotSentTableStyle;
	private GridBagConstraints createAnOrderStyle;
	
	public JPanel getPanel()
	{
		return this.panel;
	}
	
	public OrderCreationForm getOrderCreationForm()
	{
		return this.orderCreationForm;
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
		this.ordersNotSentTable = new OrdersNotSentTable();
		this.orderCreationForm = new OrderCreationForm();
		this.navigationBar = new NavigationBar();
		this.navigationBarStyle = new GridBagConstraints();
		this.medicationTableStyle = new GridBagConstraints();
		this.medicationBelowOrderThresholdTableStyle = new GridBagConstraints();
		this.ordersNotSentTableStyle = new GridBagConstraints();
		this.createAnOrderStyle = new GridBagConstraints();
	}
	
	private void styleComponents()
	{
		this.navigationBarStyle.gridy = 0;
		
		this.medicationTableStyle.gridy = 1;
		this.medicationBelowOrderThresholdTableStyle.gridy = 1;
		this.ordersNotSentTableStyle.gridy = 1;
		this.createAnOrderStyle.gridy = 1;
		
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
			this.viewMedicationTable();
		}
		else if (
			viewName.equals("MedicationBelowOrderThresholdTable")
		) {
			this.viewMedicationBelowOrderThresholdTable();
		}
		else if (
			viewName.equals("OrderCreationForm")
		) {
			this.viewCreateAnOrder();
		} else if (
			viewName.equals("OrdersNotSentTable")
		) {
			this.viewOrdersNotSentTable();
		}
	}
	
	private void viewMedicationTable()
	{
		this.panel.add(this.medicationTable.getPanel(), this.medicationTableStyle);
	}
	
	private void viewMedicationBelowOrderThresholdTable()
	{
		this.panel.add(
			this.medicationBelowOrderThresholdTable.getPanel(),
			this.medicationBelowOrderThresholdTableStyle
		);	
	}
	
	private void viewCreateAnOrder()
	{
		this.panel.add(this.orderCreationForm.getPanel(), this.createAnOrderStyle);
	}
	
	private void viewOrdersNotSentTable()
	{
		this.panel.add(this.ordersNotSentTable.getPanel(), this.ordersNotSentTableStyle);
	}
	
	private void refreshPanel() {
		panel.removeAll();
		panel.revalidate();
		panel.repaint();
	}
}
