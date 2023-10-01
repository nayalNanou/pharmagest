package view.login;

import javax.swing.*;
import java.awt.*;

public class PasswordField {
	private JPanel panel;
	private JLabel label;
	private JPasswordField textField;
	
	public JPanel getPanel()
	{
		return this.panel;
	}
	
	public JPasswordField getTextField()
	{
		return this.textField;
	}
	
	public PasswordField()
	{
		this.panel = new JPanel(new FlowLayout());
		this.label = new JLabel("Mot de passe");
		this.textField = new JPasswordField("");
		this.textField.setColumns(15);
		
		this.panel.add(this.label);
		this.panel.add(this.textField);
	}
}
