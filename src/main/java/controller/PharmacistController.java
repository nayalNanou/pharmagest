package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import view.pharmacist.OrderCreationForm;
import dao.ConnectionDatabase;
import dao.OrderFromSupplierDao;
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
	
	public static KeyListener calculateStockAndTotalPrice = new KeyListener() {
		@Override
		public void keyTyped(KeyEvent e) {}

		@Override
		public void keyPressed(KeyEvent e) {}

		@Override
		public void keyReleased(KeyEvent e) {
			OrderCreationForm orderCreationForm = Frame.panelPharmacist.getOrderCreationForm();
			JTextField textField = (JTextField) e.getSource();
			int quantityToOrder = textField.getText().equals("") ? 0 : Integer.parseInt(textField.getText());
			int maximumStock = Integer.parseInt(orderCreationForm.getMaximumStock().getTextField().getText());
			int stockInHand = Integer.parseInt(orderCreationForm.getStock().getTextField().getText());
			int stockAfterReceipt = quantityToOrder + stockInHand;
			
			if (stockAfterReceipt > maximumStock) {
				int excessStock = stockAfterReceipt - maximumStock;
				stockAfterReceipt = stockAfterReceipt - excessStock;
				quantityToOrder = quantityToOrder - excessStock;
				
				textField.setText(String.valueOf(quantityToOrder));
			}
			
			double supplierPrice = Double.parseDouble(orderCreationForm.getSupplierPrice().getTextField().getText());
			double totalPrice = supplierPrice * quantityToOrder;
			
			orderCreationForm.getStockAfterReceipt().setFieldValue(String.valueOf(stockAfterReceipt));
			orderCreationForm.getTotalPrice().setFieldValue(String.valueOf(totalPrice));
		}
	};
	
	public static ActionListener createAnOrder = new ActionListener() {
		public void actionPerformed(ActionEvent e) {		
			OrderFromSupplierDao orderFromSupplierDao = new OrderFromSupplierDao();
			OrderCreationForm orderCreationForm = Frame.panelPharmacist.getOrderCreationForm();
			int medicationId = orderCreationForm.getMedicationId();
			int quantityToOrder = Integer.parseInt(orderCreationForm.getQuantityToOrder().getTextField().getText());
			double totalPrice = Double.parseDouble(orderCreationForm.getTotalPrice().getTextField().getText());
			String status = "CREATED";
			LocalDate dateSending = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String formattedDateSending = dateSending.format(formatter);

			try {
				orderFromSupplierDao.insertData(
					medicationId,
					quantityToOrder,
					totalPrice,
					status,
					formattedDateSending
				);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			Frame.panelPharmacist.showView("OrdersNotSentTable");
			Frame.refreshFrame(Frame.panelPharmacist.getPanel());
		}
	};
	
	public static ActionListener showOrdersNotSent = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Frame.panelPharmacist.showView("OrdersNotSentTable");
			Frame.refreshFrame(Frame.panelPharmacist.getPanel());
		}
	};
	
	public static ActionListener showOrdersSent = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Liste des commandes envoyées");
		}
	};
}
