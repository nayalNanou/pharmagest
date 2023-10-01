package view.login;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

import controller.LoginController;

public class PanelLoginForm {
	private JPanel panel;
	private LoginField loginField;
	private PasswordField passwordField;
	private JButton loginButton;
	
	public JPanel getPanel()
	{
		return this.panel;
	}
	
	public LoginField getLoginField()
	{
		return this.loginField;
	}
	
	public PasswordField getPasswordField()
	{
		return this.passwordField;
	}
	
	public PanelLoginForm()
	{
		this.instantiateComponents();
		this.styleComponents();
		this.addComponents();
	}
	
	private void instantiateComponents()
	{
		this.panel = new JPanel(new GridBagLayout());
		this.loginField = new LoginField();
		this.passwordField = new PasswordField();
		this.loginButton = new JButton("Se connecter");
		
		loginButton.addActionListener(LoginController.signIn);
	}
	
	private void styleComponents()
	{
		this.panel.setBorder(this.getPanelPadding());
	}
	
	private void addComponents()
	{
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridy = 0;
		this.panel.add(loginField.getPanel(), gbc);
		gbc.gridy = 1;
		this.panel.add(passwordField.getPanel(), gbc);
		gbc.gridy = 2;
		this.panel.add(this.loginButton, gbc);
	}
	
	private Border getPanelPadding()
	{
		Border panelPadding = BorderFactory.createEmptyBorder(30, 20, 20, 30);
		return panelPadding;
	}
}
