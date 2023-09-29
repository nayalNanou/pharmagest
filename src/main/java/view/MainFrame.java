package view;

import java.sql.SQLException;

import javax.swing.*;
import view.login.PanelLoginForm;
import view.pharmacist.PanelPharmacist;

public class MainFrame {
	private JFrame frame;

	public JFrame getFrame() { return this.frame; }

	public MainFrame() throws SQLException
	{
		this.frame = new JFrame();
		PanelLoginForm panelLoginForm = new PanelLoginForm();
		PanelPharmacist panelPharmacist = new PanelPharmacist();
		
		// this.frame.add(panelLoginForm.getPanel());
		
		this.frame.add(panelPharmacist.getPanel());
		
		this.frame.setTitle("Pharmacy");
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.pack();
		this.frame.setVisible(true);
	}
	
/*	
	public void refreshPanel(JPanel newContent) {
		panelBody.removeAll();
		panelBody.add(newContent);
		panelBody.revalidate();
		panelBody.repaint();
	}
*/
}
