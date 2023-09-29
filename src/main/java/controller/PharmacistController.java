package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PharmacistController {
	public static ActionListener showMedicationList = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Liste des médicaments");
		}
	};

	public static ActionListener showMedicationBelowOrderThreshold = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Médicaments sous le seuil de commandes");
		}
	};
	
	public static ActionListener showOrdersNotSent = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Liste des commandes non envoyées");
		}
	};
	
	public static ActionListener showOrdersSent = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Liste des commandes envoyées");
		}
	};
}
