package program;

import java.sql.SQLException;
import dao.ConnectionDatabase;
import view.Frame;

import entity.User;
import dao.UserDao;

public class PharmaGestApp {
	public static void main(String[] args) throws SQLException {
		ConnectionDatabase connectionDatabase = new ConnectionDatabase();
		
		Frame.show();
		
		
Frame.panelPharmacist.showView("MedicationBelowOrderThresholdTable");
Frame.refreshFrame(Frame.panelPharmacist.getPanel());
		
		
		connectionDatabase.closeConnection();
	}
}
