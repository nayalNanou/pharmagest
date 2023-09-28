package view.login;

import javax.swing.*;
import java.awt.*;

public class LoginField {
	private JPanel panel;
	private JLabel label;
	private JTextField textField;
	
	public JPanel getPanel()
	{
		return this.panel;
	}
	
	public LoginField()
	{
		this.panel = new JPanel(new FlowLayout());
		this.label = new JLabel("Identifiant");
		this.textField = new JTextField("");
		this.textField.setColumns(15);
		
		panel.add(this.label);
		panel.add(this.textField);
	}
}
