package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
	public static ActionListener signIn = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Bienvenue sur votre espace de travail");
		}
	};
}
