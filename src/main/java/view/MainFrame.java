package view;

import javax.swing.*;

public class MainFrame {
	private JFrame frame;

	public JFrame getFrame() { return this.frame; }

	public MainFrame()
	{
		this.frame = new JFrame();
		
		this.frame.setTitle("Pharmacy");
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setSize(600, 600);
		this.frame.setVisible(true);
	}
}
