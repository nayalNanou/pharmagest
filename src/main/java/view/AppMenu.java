package view;

import javax.swing.*;
import java.awt.*;
import controller.LoginController;

public class AppMenu {
	private JPanel panel;
	private JButton logoutButton;
	
	public JPanel getPanel()
	{
		return this.panel;
	}
	
	public AppMenu()
	{
		this.instantiateComponents();
		this.implementLogic();
		this.styleComponents();
		this.addComponents();
	}
	
	public void instantiateComponents()
	{
		this.panel = new JPanel(new GridBagLayout());
		this.logoutButton = new JButton("Se déconnecter");
	}
	
	public void implementLogic()
	{
		this.logoutButton.addActionListener(LoginController.logout);
	}
	
	public void styleComponents()
	{
	
	}
	
	public void addComponents()
	{
		this.panel.add(logoutButton);
	}
}
