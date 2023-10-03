package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
import view.Frame;

public class PharmacistController {
	public static ActionListener showMedicationList = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Frame.panelPharmacist.showView("MedicationTable");
			Frame.refreshFrame(Frame.panelPharmacist.getPanel());
		}
	};

	public static ActionListener showMedicationBelowOrderThreshold = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Frame.panelPharmacist.showView("MedicationBelowOrderThresholdTable");
			Frame.refreshFrame(Frame.panelPharmacist.getPanel());
		}
	};
	
	public static ActionListener showOrderCreationForm = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JButton buttonCreateOrder = (JButton) e.getSource();
			String medicationDataString = buttonCreateOrder.getActionCommand();
			
			Frame.panelPharmacist.getOrderCreationForm().updateFormData(medicationDataString);

			Frame.panelPharmacist.showView("OrderCreationForm");
			Frame.refreshFrame(Frame.panelPharmacist.getPanel());
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
