package view;

import javax.swing.*;
import view.login.PanelLoginForm;

public class MainFrame {
	private JFrame frame;

	public JFrame getFrame() { return this.frame; }

	public MainFrame()
	{
		this.frame = new JFrame();
		PanelLoginForm panelLoginForm = new PanelLoginForm();
		
		this.frame.add(panelLoginForm.getPanel());
		
		this.frame.setTitle("Pharmacy");
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.pack();
		this.frame.setVisible(true);
	}
}
