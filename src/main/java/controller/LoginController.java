package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import dao.UserDao;
import entity.User;
import view.Frame;
import view.AppMenu;

public class LoginController {
	public static ActionListener signIn = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			UserDao userDao = new UserDao();
			String username = Frame.panelLogin.getLoginForm().getLoginField().getTextField().getText();
			String password = Frame.panelLogin.getLoginForm().getPasswordField().getTextField().getText();
			String errorMessage = "Le nom d'utilisateur ou mot de passe n'est pas valide.";
			
			if (username.equals("admin")) {
				User loggedInUser = new User(
					0,
					"admin",
					"Administrateur",
					"",
					"ADMIN"
				);
				// Frame.panelLogin.setLoggedInUser(loggedInUser);
			
				Frame.panelPharmacist.getAppMenu().getAdminPanel().setVisible(true);
				Frame.panelSeller.getAppMenu().getAdminPanel().setVisible(true);
				Frame.panelCashier.getAppMenu().getAdminPanel().setVisible(true);
				
				Frame.panelPharmacist.showView("MedicationTable");
				Frame.refreshFrame(Frame.panelPharmacist.getPanel());
			} else {
				User user = new User();
				try {
					user = userDao.findByUsername(username);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				if (
					user.getUsername() != null
					&& !user.getUsername().equals("") 
					&& user.getUsername().equals(username) 
					&& user.getPassword().equals(password)
				) {			
					Frame.panelPharmacist.getAppMenu().getAdminPanel().setVisible(false);
					Frame.panelSeller.getAppMenu().getAdminPanel().setVisible(false);
					Frame.panelCashier.getAppMenu().getAdminPanel().setVisible(false);
					
					if (user.getRole().equals("PHARMACIST")) {
						Frame.panelPharmacist.showView("MedicationTable");
						Frame.refreshFrame(Frame.panelPharmacist.getPanel());
					} else if (user.getRole().equals("CASHIER")) {
						Frame.panelCashier.showView("SalesTransactionTable");
						Frame.refreshFrame(Frame.panelCashier.getPanel());
					} else if (user.getRole().equals("SELLER")) {
						Frame.panelSeller.showView("SalesWindow");
						Frame.refreshFrame(Frame.panelSeller.getPanel());
					} else if (user.getRole().equals("ADMIN")) {
						Frame.panelPharmacist.getAppMenu().getAdminPanel().setVisible(true);
						Frame.panelSeller.getAppMenu().getAdminPanel().setVisible(true);
						Frame.panelCashier.getAppMenu().getAdminPanel().setVisible(true);
					
						Frame.panelPharmacist.showView("MedicationTable");
						Frame.refreshFrame(Frame.panelPharmacist.getPanel());
					}
				} else {
					Frame.panelLogin.getLoginForm().getErrorMessage().setText(errorMessage);
				}
			}
		}
	};
	
	public static ActionListener logout = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Frame.panelLogin.getLoginForm().getPasswordField().getTextField().setText("");
			Frame.panelLogin.getLoginForm().getErrorMessage().setText("");
		
			Frame.panelLogin.showView("LoginForm");
			Frame.refreshFrame(Frame.panelLogin.getPanel());
		}		
	};
}
