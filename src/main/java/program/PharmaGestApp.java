package program;

import java.sql.SQLException;

import dao.ConnectionDatabase;

import dao.SupplierDao;
import java.util.ArrayList;
import entity.Supplier;

public class PharmaGestApp {
	public static void main(String[] args) throws SQLException {
		ConnectionDatabase connectionDatabase = new ConnectionDatabase();
		
		SupplierDao supplierDao = new SupplierDao();
		ArrayList<Supplier> suppliers = supplierDao.getSuppliers();
		
		System.out.println(suppliers.get(1).getName());
		
		connectionDatabase.closeConnection();
	}
}
