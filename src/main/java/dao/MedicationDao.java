package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.MedicationCategory;
import entity.Medication;
import entity.Supplier;

public class MedicationDao extends ConnectionDatabase {
	public ArrayList<Medication> findAll() throws SQLException
	{
		ArrayList<Medication> listMedication = new ArrayList<Medication>();
		this.statement = this.connection.createStatement();
		ResultSet rs = this.statement.executeQuery(
			"SELECT m.id AS medication_id, m.name AS medication_name, m.pharmacy_price, " + 
			"mc.id AS medication_category_id, mc.name AS medication_category_name, " + 
			"m.prescription, m.stock_in_hand, m.maximum_stock, " +
			"m.minimum_threshold_before_supply_order, m.supplier_price, s.id AS supplier_id, " +
			"s.name AS supplier_name " +
			"FROM medication AS m " +
			"INNER JOIN medication_category AS mc " +
			"ON m.medication_category_id = mc.id " +
			"INNER JOIN supplier AS s " +
			"ON m.supplier_id = s.id;"
		);
		
		while(rs.next()) {			
			Medication medication = new Medication(
				rs.getInt("medication_id"),
				rs.getString("medication_name"),
				rs.getDouble("pharmacy_price"),
				new MedicationCategory(
					rs.getInt("medication_category_id"),
					rs.getString("medication_category_name")
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
			
			listMedication.add(medication);
		}
		rs.close();
		statement.close();
		
		return listMedication;
	}
	
	public ArrayList<Medication> findMedicationBelowOrderThreshold() throws SQLException
	{
		ArrayList<Medication> listMedication = new ArrayList<Medication>();
		this.statement = this.connection.createStatement();
		ResultSet rs = this.statement.executeQuery(
			"SELECT m.id AS medication_id, m.name AS medication_name, m.pharmacy_price, " +
			"mc.id AS medication_category_id, mc.name AS medication_category_name, " +
			"m.prescription, m.stock_in_hand, m.maximum_stock, " +
			"m.minimum_threshold_before_supply_order, m.supplier_price, s.id AS supplier_id, " +
			"s.name AS supplier_name " +
			"FROM medication AS m " +
			"INNER JOIN medication_category AS mc " +
			"ON m.medication_category_id = mc.id " +
			"INNER JOIN supplier AS s " +
			"ON m.supplier_id = s.id " +
			"WHERE m.stock_in_hand <= m.minimum_threshold_before_supply_order;"
		);
		
		while (rs.next()) {
			Medication medication = new Medication(
				rs.getInt("medication_id"),
				rs.getString("medication_name"),
				rs.getDouble("pharmacy_price"),
				new MedicationCategory(
					rs.getInt("medication_category_id"),
					rs.getString("medication_category_name")
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
			
			listMedication.add(medication);
		}
		
		return listMedication;
	}
}
