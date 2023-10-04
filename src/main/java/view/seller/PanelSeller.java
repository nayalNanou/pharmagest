package view.seller;

import java.awt.*;
import java.sql.SQLException;

import javax.swing.*;

import view.Frame;
import view.menu.AppMenu;

public class PanelSeller {
	private JPanel panel;
	private GridBagConstraints appMenuStyle;
	private SalesWindow salesWindow;
	private GridBagConstraints salesWindowStyle;
	
	public JPanel getPanel()
	{
		return this.panel;
	}
	
	public PanelSeller() throws SQLException
	{
		this.instantiateComponents();
		this.styleComponents();
		this.addComponents();
	}
	
	private void instantiateComponents() throws SQLException
	{
		this.panel = new JPanel(new GridBagLayout());
		// this.appMenu = new AppMenu();
		this.appMenuStyle = new GridBagConstraints();
		this.salesWindow = new SalesWindow();
		this.salesWindowStyle = new GridBagConstraints();
	}
	
	private void styleComponents()
	{
		this.appMenuStyle.gridy = 0;
		this.salesWindowStyle.gridy = 1;
	}
	
	private void addComponents()
	{
		this.panel.add(this.salesWindow.getPanel(), this.salesWindowStyle);
	}
	
	public void showView(String viewName)
	{
		this.refreshPanel();
		
		// this.panel.add(this.appMenu.getPanel(), this.appMenuStyle);
		
		this.selectedView(viewName);
		Frame.resizeFrame();
	}
	
	private void selectedView(String viewName)
	{
		if (
			viewName.equals("SalesWindow")
		) {
			this.viewSalesWindow();
		}
	}
	
	private void viewSalesWindow()
	{
		this.panel.add(this.salesWindow.getPanel(), this.salesWindowStyle);
	}
	
	private void refreshPanel() {
		panel.removeAll();
		panel.revalidate();
		panel.repaint();
	}
}
