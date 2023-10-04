package view;

import java.awt.GridBagLayout;
import java.sql.SQLException;

import javax.swing.*;
import java.awt.*;
import view.login.PanelLogin;
import view.menu.AppMenu;
import view.pharmacist.PanelPharmacist;
import view.seller.PanelSeller;
import view.cashier.PanelCashier;

public class Frame {
	private static JFrame frame;
	private static JPanel panel;
	public static AppMenu appMenu;
	public static PanelLogin panelLogin;
	public static PanelPharmacist panelPharmacist;
	public static PanelSeller panelSeller;
	public static PanelCashier panelCashier;
	
	public static void show() throws SQLException
	{
		instantiateComponents();
		addComponents();
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	private static void instantiateComponents() throws SQLException
	{
		frame = new JFrame();
		frame.setTitle("Pharmacy");
		panel = new JPanel(new GridBagLayout());
		appMenu = new AppMenu();
		panelLogin = new PanelLogin();
		panelPharmacist = new PanelPharmacist();
		panelSeller = new PanelSeller();
		panelCashier = new PanelCashier();
	}
	
	private static void addComponents()
	{
		panel.add(panelLogin.getPanel());
		frame.add(panel);	
	}
	
	public static void refreshFrame(JPanel newContent) {
		panel.removeAll();
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridy = 0;
		panel.add(appMenu.getPanel(), gbc);
		gbc.gridy = 1;
		panel.add(newContent, gbc);
		
		frame.pack();
		panel.revalidate();
		panel.repaint();
	}
	
	public static void resizeFrame()
	{
		frame.pack();
	}
}
