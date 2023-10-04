package view;

import javax.swing.*;
import java.awt.*;
import controller.LoginController;
import controller.PharmacistController;
import controller.SellerController;
import view.login.PanelLogin;
import controller.CashierController;

public class AppMenu {
	private JPanel panel;
	private JButton logoutButton;
	private JPanel userPanel;
	private JPanel adminPanel;
	private JButton buttonPharmacist;
	private JButton buttonSeller;
	private JButton buttonCashier;
	
	private GridBagConstraints userPanelStyle;
	private GridBagConstraints adminPanelStyle;
	
	public JPanel getPanel()
	{
		return this.panel;
	}
	
	public JPanel getAdminPanel()
	{
		return this.adminPanel;
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

		this.userPanel = new JPanel(new GridBagLayout());
		this.adminPanel = new JPanel(new GridBagLayout());
		
		this.buttonPharmacist = new JButton("Pharmacien");
		this.buttonSeller = new JButton("Vendeur");
		this.buttonCashier = new JButton("Caissier");
		
		this.userPanelStyle = new GridBagConstraints();
		this.adminPanelStyle = new GridBagConstraints();
	}
	
	public void implementLogic()
	{
		this.logoutButton.addActionListener(LoginController.logout);
		
		this.buttonPharmacist.addActionListener(PharmacistController.showMedicationList);
		this.buttonSeller.addActionListener(SellerController.showSalesWindow);
		this.buttonCashier.addActionListener(CashierController.showSalesTransactionTable);
		
		this.adminPanel.setVisible(false);
	}
	
	public void styleComponents()
	{
		this.userPanelStyle.gridy = 0;
		this.adminPanelStyle.gridy = 1;
	}
	
	public void addComponents()
	{
		this.userPanel.add(logoutButton);
		this.adminPanel.add(this.buttonPharmacist);
		this.adminPanel.add(this.buttonSeller);
		this.adminPanel.add(this.buttonCashier);
		this.panel.add(userPanel, this.userPanelStyle);
		this.panel.add(adminPanel, this.adminPanelStyle);
	}
}
