package controller;

import view.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CashierController {
	public static ActionListener showSalesTransactionTable = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Frame.panelCashier.showView("SalesTransactionTable");
			Frame.refreshFrame(Frame.panelCashier.getPanel());		
		}
	};
}
