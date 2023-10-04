package view.login;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class PasswordField {
	private JPanel panel;
	private JLabel label;
	private JPasswordField textField;
	private GridBagConstraints labelStyle;
	private GridBagConstraints textFieldStyle;
	
	public JPanel getPanel()
	{
		return this.panel;
	}
	
	public JPasswordField getTextField()
	{
		return this.textField;
	}
	
	public PasswordField(String labelText)
	{
		this.instantiateComponents(labelText);
		this.styleComponents();
		this.addComponents();
	}
	
	public void instantiateComponents(String labelText)
	{
		this.panel = new JPanel(new GridBagLayout());
		this.label = new JLabel(labelText);
		this.textField = new JPasswordField("");		
		this.labelStyle = new GridBagConstraints();
		this.textFieldStyle = new GridBagConstraints();
	}
	
	public void styleComponents()
	{
		this.label.setFont(new Font("Arial", Font.PLAIN, 18));
		this.label.setBorder(BorderFactory.createEmptyBorder(0, 0, 4, 0));
		this.textField.setColumns(20);
		this.textField.setFont(new Font("Arial", Font.PLAIN, 20));
		
		this.textField.setBorder(
			BorderFactory.createCompoundBorder(
	        	this.textField.getBorder(), 
	        	BorderFactory.createEmptyBorder(5, 5, 5, 5)
	        )
        );
		
		this.labelStyle.gridy = 0;
		this.labelStyle.anchor = GridBagConstraints.WEST;
		this.textFieldStyle.gridy = 1;
		
		this.panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	}
	
	public void addComponents()
	{
		panel.add(this.label, this.labelStyle);
		panel.add(this.textField, this.textFieldStyle);
	}
}
