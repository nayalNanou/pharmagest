package view.login;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

import controller.LoginController;
import view.Frame;
import entity.User;

public class PanelLogin {
	private JPanel panel;
	private LoginForm loginForm;
	private static User loggedInUser;
	
	public static User getLoggedInUser()
	{
		return loggedInUser;
	}
	
	public static void setLoggedInUser(User user)
	{
		loggedInUser = user;
	}
	
	public JPanel getPanel()
	{
		return this.panel;
	}
	
	public LoginForm getLoginForm()
	{
		return this.loginForm;
	}
	
	public PanelLogin()
	{
		this.instantiateComponents();
		this.styleComponents();
		this.addComponents();
	}
	
	public void instantiateComponents()
	{
		this.panel = new JPanel();
		this.loginForm = new LoginForm();
	}
	
	public void styleComponents()
	{
	
	}
	
	public void addComponents()
	{
		this.panel.add(this.loginForm.getPanel());
	}
		
	public void showView(String viewName)
	{
		this.refreshPanel();
		
		// this.panel.add(this.navigationBar.getPanel(), this.navigationBarStyle);
		
		this.selectedView(viewName);
		Frame.resizeFrame();
	}
	
	private void selectedView(String viewName)
	{
		if (
			viewName.equals("LoginForm")
		) {
			this.viewLoginForm();
		}
	}
	
	private void viewLoginForm()
	{
		this.panel.add(this.loginForm.getPanel());
	}
	
	private void refreshPanel() {
		panel.removeAll();
		panel.revalidate();
		panel.repaint();
	}
}
