package view;

import java.sql.SQLException;

import javax.swing.*;
import view.login.PanelLoginForm;
import view.pharmacist.PanelPharmacist;

public class Frame {
	private static JFrame frame;
	private static JPanel panel;
	public static PanelLoginForm panelLoginForm;
	public static PanelPharmacist panelPharmacist;
	
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
		panelLoginForm = new PanelLoginForm();
		panelPharmacist = new PanelPharmacist();
	}
	
	private static void addComponents()
	{
		panel.add(panelLoginForm.getPanel());
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