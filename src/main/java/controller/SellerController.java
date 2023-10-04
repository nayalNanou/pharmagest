package controller;

import view.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SellerController {
	public static ActionListener showSalesWindow = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Frame.panelSeller.showView("SalesWindow");
			Frame.refreshFrame(Frame.panelSeller.getPanel());		
		}
	};
}
