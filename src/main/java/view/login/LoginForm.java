package view.login;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.LoginController;

public class LoginForm {
	private JLabel appTitle;
	private JPanel panel;
	private JPanel topBlock;
	private JPanel bottomBlock;
	private LoginField loginField;
	private PasswordField passwordField;
	private JButton loginButton;
	
	private GridBagConstraints appTitleStyle;
	private GridBagConstraints loginFieldStyle;
	private GridBagConstraints passwordFieldStyle;
	private GridBagConstraints loginButtonStyle;
	
	private GridBagConstraints topBlockStyle;
	private GridBagConstraints bottomBlockStyle;
	
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
	
	public LoginForm()
	{
		this.instantiateComponents();
		this.implementLogic();
		this.styleComponents();
		this.addComponents();
	}
	
	private void instantiateComponents()
	{
		this.appTitle = new JLabel("PharmaGest");
		this.panel = new JPanel(new GridBagLayout());
		this.topBlock = new JPanel(new GridBagLayout());
		this.bottomBlock = new JPanel(new GridBagLayout());
		this.loginField = new LoginField("Nom d'utilisateur");
		this.passwordField = new PasswordField("Mot de passe");
		this.loginButton = new JButton("Se connecter");
		
		this.appTitleStyle = new GridBagConstraints();
		this.loginFieldStyle = new GridBagConstraints();
		this.passwordFieldStyle = new GridBagConstraints();
		this.loginButtonStyle = new GridBagConstraints();
		
		this.topBlockStyle = new GridBagConstraints();
		this.bottomBlockStyle = new GridBagConstraints();
	}
	
	private void implementLogic()
	{
		loginButton.addActionListener(LoginController.signIn);
	}
	
	private void styleComponents()
	{
		this.panel.setBorder(BorderFactory.createEmptyBorder(60, 60, 60, 60));

		this.appTitle.setFont(new Font("Arial", Font.PLAIN, 30));
		this.appTitle.setBorder(BorderFactory.createEmptyBorder(0, 0, 40, 0));
		
		this.loginButton.setFont(new Font("Arial", Font.PLAIN, 18));
		this.loginButton.setBorder(
			BorderFactory.createCompoundBorder(
				this.loginButton.getBorder(),
				BorderFactory.createEmptyBorder(5, 40, 5, 40)
			)
		);
		
		this.bottomBlock.setBorder(BorderFactory.createEmptyBorder(14, 0, 0, 0));
		
		this.topBlockStyle.gridy = 0;
		this.bottomBlockStyle.gridy = 1;
		
		this.appTitleStyle.gridy = 0;
		this.loginFieldStyle.gridy = 1;
		this.passwordFieldStyle.gridy = 2;
		
		this.loginButtonStyle.gridy = 2;
	}
	
	private void addComponents()
	{
		this.topBlock.add(this.appTitle, this.appTitleStyle);
		this.topBlock.add(this.loginField.getPanel(), this.loginFieldStyle);
		this.topBlock.add(this.passwordField.getPanel(), this.passwordFieldStyle);
		this.bottomBlock.add(this.loginButton, this.loginButtonStyle);
		this.panel.add(this.topBlock, this.topBlockStyle);
		this.panel.add(this.bottomBlock, this.bottomBlockStyle);
	}
}
