package view.cashier;

import javax.swing.JPanel;
import java.awt.*;
import view.Frame;
import view.AppMenu;

public class PanelCashier {
	private JPanel panel;
	private AppMenu appMenu;
	private SalesTransactionTable salesTransactionTable;
	
	private GridBagConstraints appMenuStyle;
	private GridBagConstraints salesTransactionTableStyle;
	
	public JPanel getPanel()
	{
		return this.panel;
	}
	
	public AppMenu getAppMenu()
	{
		return this.appMenu;
	}
	
	public SalesTransactionTable getSalesTransactionTable()
	{
		return this.salesTransactionTable;
	}
	
	public PanelCashier()
	{
		this.instantiateComponents();
		this.styleComponents();
		this.addComponents();
	}
	
	public void instantiateComponents()
	{
		this.panel = new JPanel(new GridBagLayout());
		this.appMenu = new AppMenu();
		this.salesTransactionTable = new SalesTransactionTable();
		
		this.appMenuStyle = new GridBagConstraints();
		this.salesTransactionTableStyle = new GridBagConstraints();
	}
	
	public void styleComponents()
	{
		this.appMenuStyle.gridy = 0;
		this.salesTransactionTableStyle.gridy = 1;
	}
	
	public void addComponents()
	{
		this.panel.add(this.appMenu.getPanel(), this.appMenuStyle);
		this.panel.add(this.salesTransactionTable.getPanel(), this.salesTransactionTableStyle);
	}
		
	public void showView(String viewName)
	{
		this.refreshPanel();
		
		this.panel.add(this.appMenu.getPanel(), this.appMenuStyle);
		
		this.selectedView(viewName);
		Frame.resizeFrame();
	}
	
	private void selectedView(String viewName)
	{
		if (
			viewName.equals("SalesTransactionTable")
		) {
			this.viewSalesTransactionTable();
		}
	}
	
	private void viewSalesTransactionTable()
	{
		this.panel.add(this.salesTransactionTable.getPanel(), this.salesTransactionTableStyle);
	}
	
	private void refreshPanel() {
		panel.removeAll();
		panel.revalidate();
		panel.repaint();
	}
}
