package view;

import java.sql.SQLException;

import javax.swing.*;
import view.login.PanelLogin;
import view.pharmacist.PanelPharmacist;
import view.seller.PanelSeller;

public class Frame {
	private static JFrame frame;
	private static JPanel panel;
	public static PanelLogin panelLogin;
	public static PanelPharmacist panelPharmacist;
	public static PanelSeller panelSeller;
	
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
		panel = new JPanel();
		panelLogin = new PanelLogin();
		panelPharmacist = new PanelPharmacist();
		panelSeller = new PanelSeller();
	}
	
	private static void addComponents()
	{
		panel.add(panelLogin.getPanel());
		frame.add(panel);	
	}
	
	public static void refreshFrame(JPanel newContent) {
		panel.removeAll();
		panel.add(newContent);
		frame.pack();
		panel.revalidate();
		panel.repaint();
	}
	
	public static void resizeFrame()
	{
		frame.pack();
	}
}
