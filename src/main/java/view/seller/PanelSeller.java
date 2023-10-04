package view.seller;

import java.awt.*;
import java.sql.SQLException;

import javax.swing.*;

import view.Frame;

public class PanelSeller {
	private JPanel panel;
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
		this.salesWindow = new SalesWindow();
		this.salesWindowStyle = new GridBagConstraints();
	}
	
	private void styleComponents()
	{
		this.salesWindowStyle.gridy = 1;
	}
	
	private void addComponents()
	{
		this.panel.add(this.salesWindow.getPanel(), this.salesWindowStyle);
	}
	
	public void showView(String viewName)
	{
		this.refreshPanel();
		
		// this.panel.add(this.navigationBar.getPanel(), this.navigationBarStyle);
		
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
