package view.pharmacist;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import dao.OrderFromSupplierDao;
import entity.OrderFromSupplier;

public class OrdersNotSentTable {
	private OrderFromSupplierDao orderFromSupplierDao;
	private JPanel panel;
	private JPanel table;
	private ArrayList<Object[]> tableRows;
	private ArrayList<GridBagConstraints[]> tableRowsStyle;
	
	public JPanel getPanel()
	{
		return this.panel;
	}
	
	public OrdersNotSentTable() throws SQLException
	{
		this.instantiateComponents();
		this.implementLogic();
		this.styleComponents();
		this.addComponents();
	}
	
	public void instantiateComponents()
	{
		this.orderFromSupplierDao = new OrderFromSupplierDao();
		this.panel = new JPanel();
		this.table = new JPanel(new GridBagLayout());
		this.tableRows = new ArrayList<Object[]>();
		this.tableRowsStyle = new ArrayList<GridBagConstraints[]>();
	}
	
	public void implementLogic() throws SQLException
	{
		ArrayList<OrderFromSupplier> ordersNotSent = this.orderFromSupplierDao.getOrdersNotSent();
		String[] columnNames = {"Médicament", "Fournisseur", "Prix du fournisseur", "Quantité commandé", "Prix total", "Action"};
		int columnNamesLen = columnNames.length;
		int ordersNotSentLen = ordersNotSent.size();
		
		Object[] tableHeader = new Object[columnNamesLen];
		
		for (int i = 0; i < columnNamesLen; i++) {
			tableHeader[i] = new JLabel(columnNames[i]);
		}
		
		this.tableRows.add(tableHeader);
		
		for (int i = 0; i < ordersNotSentLen; i++) {
			OrderFromSupplier orderFromSupplier = ordersNotSent.get(i);
			Object[] tableRow = new Object[columnNamesLen + 1];
			
			tableRow[0] = new JLabel(orderFromSupplier.getMedication().getName());
			tableRow[1] = new JLabel(orderFromSupplier.getMedication().getSupplier().getName());
			tableRow[2] = new JLabel(String.valueOf(orderFromSupplier.getMedication().getSupplierPrice()));
			tableRow[3] = new JLabel(String.valueOf(orderFromSupplier.getQuantityOrdered()));
			tableRow[4] = new JLabel(String.valueOf(orderFromSupplier.getTotalPrice()));
			
			JButton buttonEditOrderFromSupplier = new JButton("Modifier");
			JButton buttonDeleteOrderFromSupplier = new JButton("Supprimer");
			
			tableRow[5] = buttonEditOrderFromSupplier;
			tableRow[6] = buttonDeleteOrderFromSupplier;
			
			this.tableRows.add(tableRow);
		}
	}
	
	public void styleComponents()
	{
		int tableRowsLen = this.tableRows.size();
		
		for (int i = 0; i < tableRowsLen; i++) {
			int tableRowLen = this.tableRows.get(i).length;
			GridBagConstraints[] tableRowStyle = new GridBagConstraints[tableRowLen];
			
			System.out.println(tableRowLen);
			
			GridBagConstraints medicationNameStyle = new GridBagConstraints();
			medicationNameStyle.gridy = i;
			medicationNameStyle.gridx = 0;
			tableRowStyle[0] = medicationNameStyle;
			
			GridBagConstraints supplierNameStyle = new GridBagConstraints();
			supplierNameStyle.gridy = i;
			supplierNameStyle.gridx = 1;
			tableRowStyle[1] = supplierNameStyle;
			
			GridBagConstraints supplierPriceStyle = new GridBagConstraints();
			supplierPriceStyle.gridy = i;
			supplierPriceStyle.gridx = 2;
			tableRowStyle[2] = supplierPriceStyle;
			
			GridBagConstraints quantityOrderedStyle = new GridBagConstraints();
			quantityOrderedStyle.gridy = i;
			quantityOrderedStyle.gridx = 3;
			tableRowStyle[3] = quantityOrderedStyle;
			
			GridBagConstraints totalPriceStyle = new GridBagConstraints();
			totalPriceStyle.gridy = i;
			totalPriceStyle.gridx = 4;
			tableRowStyle[4] = totalPriceStyle;
			
			GridBagConstraints actionEditStyle = new GridBagConstraints();
			actionEditStyle.gridy = i;
			actionEditStyle.gridx = 5;
			tableRowStyle[5] = actionEditStyle;
			
			if (i > 0) {
				System.out.println(i);
				GridBagConstraints actionDeleteStyle = new GridBagConstraints();
				actionDeleteStyle.gridy = i;
				actionDeleteStyle.gridx = 6;
				tableRowStyle[6] = actionDeleteStyle;
			}
			
			this.tableRowsStyle.add(tableRowStyle);
		}
	}
	
	public void addComponents()
	{
		int tableRowsLen = this.tableRows.size();
		
		for (int i = 0; i < tableRowsLen; i++) {
			Object[] tableRow = tableRows.get(i);
			GridBagConstraints[] tableRowStyle = tableRowsStyle.get(i);
			int tableRowLen = tableRow.length;
			
			for (int j = 0; j < tableRowLen; j++) {
				boolean isTableHeader = i == 0;
				boolean isTableActionButtons = j >= tableRowLen - 2;
			
				if (isTableHeader) {
					this.table.add((JLabel) tableRow[j], (GridBagConstraints) tableRowStyle[j]);
				} else {
					if (isTableActionButtons) {
						this.table.add((JButton) tableRow[j], (GridBagConstraints) tableRowStyle[j]);
					} else {
						this.table.add((JLabel) tableRow[j], (GridBagConstraints) tableRowStyle[j]);
					}
				}
			}
		}
	
		this.panel.add(this.table);
	}
}
