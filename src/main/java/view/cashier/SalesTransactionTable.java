package view.cashier;

import javax.swing.*;
import java.awt.*;

public class SalesTransactionTable {
	private JPanel panel;
	
	public JPanel getPanel()
	{
		return this.panel;
	}
	
	public SalesTransactionTable()
	{
		this.instantiateComponents();
		this.styleComponents();
		this.addComponents();
	}
	
	public void instantiateComponents()
	{
		this.panel = new JPanel(new GridBagLayout());
	}
	
	public void styleComponents()
	{
	
	}
	
	public void addComponents()
	{
		JLabel message = new JLabel("Vue du caissier : travail en cours");
		message.setFont(new Font("Arial", Font.BOLD, 40));
		message.setBorder(BorderFactory.createEmptyBorder(80, 80, 80, 80));
	
		this.panel.add(message);
	}
}
