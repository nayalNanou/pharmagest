package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.CategoryMedicine;
import entity.Medicine;
import entity.Supplier;

public class MedicineDao extends ConnectionDatabase {
	public ArrayList<Medicine> getList() throws SQLException
	{
		ArrayList<Medicine> medicines = new ArrayList<Medicine>();
		this.statement = this.connection.createStatement();
		ResultSet rs = this.statement.executeQuery(
			"SELECT m.id AS medicine_id, m.name AS medicine_name, m.pharmacy_price, " + 
			"cm.id AS category_medicine_id, cm.name AS category_medicine_name, " + 
			"m.prescription, m.stock_in_hand, m.maximum_stock, " +
			"m.minimum_threshold_before_supply_order, m.supplier_price, s.id AS supplier_id, " +
			"s.name AS supplier_name " +
			"FROM medicine AS m " +
			"INNER JOIN category_medicine AS cm " +
			"ON m.category_medicine_id = cm.id " +
			"INNER JOIN supplier AS s " +
			"ON m.supplier_id = s.id;"
		);
		
		while(rs.next()) {			
			Medicine medicine = new Medicine(
				rs.getInt("medicine_id"),
				rs.getString("medicine_name"),
				rs.getDouble("pharmacy_price"),
				new CategoryMedicine(
					rs.getInt("category_medicine_id"),
					rs.getString("category_medicine_name")
				),
				rs.getBoolean("prescription"),
				rs.getInt("stock_in_hand"),
				rs.getInt("maximum_stock"),
				rs.getInt("minimum_threshold_before_supply_order"),
				rs.getDouble("supplier_price"),
				new Supplier(
					rs.getInt("supplier_id"),
					rs.getString("supplier_name")
				)
			);
			
			medicines.add(medicine);
		}
		rs.close();
		statement.close();
		
		return medicines;
	}
}
