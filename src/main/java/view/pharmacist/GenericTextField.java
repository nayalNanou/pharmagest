package view.pharmacist;

import javax.swing.*;
import java.awt.*;

public class GenericTextField {
	private JPanel panel;
	private JLabel label;
	private JTextField textField;
	private GridBagConstraints labelStyle;
	private GridBagConstraints textFieldStyle;
	
	public JPanel getPanel()
	{
		return this.panel;
	}
	
	public GenericTextField(String labelText, String fieldValue)
	{
		this.instantiateComponents(labelText, fieldValue);
		this.styleComponents();
		this.addComponents();
	}
	
	private void instantiateComponents(String labelText, String fieldValue)
	{
		this.panel = new JPanel(new GridBagLayout());
		this.label = new JLabel(labelText);
		this.textField = new JTextField(fieldValue);
		
		this.labelStyle = new GridBagConstraints();
		this.textFieldStyle = new GridBagConstraints();
	}
	
	private void styleComponents()
	{
		this.textField.setColumns(15);
	
		this.labelStyle.gridy = 0;
		this.labelStyle.anchor = GridBagConstraints.WEST;
		this.textFieldStyle.gridy = 1;
	}
	
	private void addComponents()
	{
		this.panel.add(this.label, this.labelStyle);
		this.panel.add(this.textField, this.textFieldStyle);
	}
}
