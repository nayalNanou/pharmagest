package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import dao.UserDao;
import entity.User;
import view.Frame;

public class LoginController {
	public static ActionListener signIn = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			UserDao userDao = new UserDao();
			String username = Frame.panelLoginForm.getLoginField().getTextField().getText();
			String password = Frame.panelLoginForm.getPasswordField().getTextField().getText();
			String errorMessage = "Le nom d'utilisateur ou mot de passe n'est pas valide.";
			
			User user = new User();
			try {
				user = userDao.findByUsername(username);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			if (
				!user.getUsername().equals("") 
				&& user.getUsername().equals(username) 
				&& user.getPassword().equals(password)
			) {
				if (user.getRole().equals("PHARMACIST")) {
					Frame.panelPharmacist.showView("MedicationTable");
					Frame.refreshFrame(Frame.panelPharmacist.getPanel());
				} else if (user.getRole().equals("CASHIER")) {
				
				} else if (user.getRole().equals("SELLER")) {
					Frame.panelPharmacist.showView("SalesWindow");
					Frame.refreshFrame(Frame.panelSeller.getPanel());
				} else if (user.getRole().equals("ADMIN")) {
				
				} else {
				
				}
			
				System.out.println("Bienvenue sur votre espace de travail");
			} else {
				System.out.println(errorMessage);
			}
		}
	};
}
