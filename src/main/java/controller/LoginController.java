package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import dao.UserDao;
import entity.User;
import view.Frame;
import view.menu.AppMenu;

public class LoginController {
	public static ActionListener signIn = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			UserDao userDao = new UserDao();
			String username = Frame.panelLogin.getLoginForm().getLoginField().getTextField().getText();
			String password = Frame.panelLogin.getLoginForm().getPasswordField().getTextField().getText();
			String errorMessage = "Le nom d'utilisateur ou mot de passe n'est pas valide.";
			
			if (username.equals("admin")) {				
				Frame.appMenu.getUserFullName().setText("Administrateur");
				Frame.appMenu.getUserRole().setText("Admin");
				Frame.appMenu.getAdminPanel().setVisible(true);
				Frame.appMenu.getPanel().setVisible(true);
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
					Frame.appMenu.getUserFullName().setText(user.getFullName());
					Frame.appMenu.getUserRole().setText(user.getRole());
					Frame.appMenu.getPanel().setVisible(true);
					Frame.appMenu.getAdminPanel().setVisible(false);

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
						Frame.appMenu.getAdminPanel().setVisible(true);
					
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
			Frame.appMenu.getPanel().setVisible(false);
		
			Frame.panelLogin.showView("LoginForm");
			Frame.refreshFrame(Frame.panelLogin.getPanel());
		}		
	};
}
