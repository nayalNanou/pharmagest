package program;

import java.sql.SQLException;

import dao.ConnectionDatabase;

import dao.CategoryMedicineDao;
import java.util.ArrayList;
import entity.CategoryMedicine;

public class PharmaGestApp {
	public static void main(String[] args) throws SQLException {
		ConnectionDatabase connectionDatabase = new ConnectionDatabase();
		

		
		connectionDatabase.closeConnection();
	}
}
