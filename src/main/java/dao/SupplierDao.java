package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entity.Supplier;

public class SupplierDao extends ConnectionDatabase {
	public ArrayList<Supplier> getSuppliers() throws SQLException
	{
		ArrayList<Supplier> suppliers = new ArrayList<Supplier>();	
		this.statement = this.connection.createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM supplier;");
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			Supplier supplier = new Supplier(id, name);
			
			suppliers.add(supplier);
		 }
		 rs.close();
		 statement.close();
		 
		 return suppliers;
	}
}
