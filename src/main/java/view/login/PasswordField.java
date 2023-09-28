package view.login;

import javax.swing.*;
import java.awt.*;

public class PasswordField {
	private JPanel panel;
	private JLabel label;
	private JTextField textField;
	
	public JPanel getPanel()
	{
		return this.panel;
	}
	
	public PasswordField()
	{
		this.panel = new JPanel(new FlowLayout());
		this.label = new JLabel("Mot de passe");
		this.textField = new JTextField("");
		this.textField.setColumns(15);
		
		this.panel.add(this.label);
		this.panel.add(this.textField);
	}
}
