package view.utility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GenericTextField {
	private JPanel panel;
	private JLabel label;
	private JTextField textField;
	private boolean isEnabled;
	private GridBagConstraints labelStyle;
	private GridBagConstraints textFieldStyle;
	
	public JPanel getPanel()
	{
		return this.panel;
	}
	
	public void setFieldValue(String fieldValue)
	{
		this.textField.setText(fieldValue);
	}
	
	public JTextField getTextField()
	{
		return this.textField;
	}
	
	public GenericTextField(String labelText, boolean isEnabled)
	{
		this.isEnabled = isEnabled;
		
		this.instantiateComponents(labelText);
		this.styleComponents();
		this.addComponents();
	}
	
	private void instantiateComponents(String labelText)
	{
		this.panel = new JPanel(new GridBagLayout());
		this.label = new JLabel(labelText);
		this.textField = new JTextField();
		this.textField.setEnabled(this.isEnabled);
		
		this.labelStyle = new GridBagConstraints();
		this.textFieldStyle = new GridBagConstraints();
	}
	
	private void styleComponents()
	{
		// If the textField is disabled
		this.textField.setDisabledTextColor(Color.GRAY);
		
		this.textField.setFont(new Font("Serif", Font.PLAIN, 16));
		
		this.panel.setBorder(BorderFactory.createEmptyBorder(4, 4, 8, 4));
		this.textField.setColumns(18);
	
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
