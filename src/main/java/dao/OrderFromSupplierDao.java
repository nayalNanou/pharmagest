package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import entity.Medication;
import entity.MedicationCategory;
import entity.OrderFromSupplier;
import entity.Supplier;

public class OrderFromSupplierDao extends ConnectionDatabase {
	public ArrayList<OrderFromSupplier> getOrdersNotSent() throws SQLException
	{
		ArrayList<OrderFromSupplier> ordersNotSent = new ArrayList<OrderFromSupplier>();
		this.statement = this.connection.createStatement();
		ResultSet rs = this.statement.executeQuery(
			"SELECT ofs.id AS order_from_supplier_id, ofs.quantity_ordered, ofs.status, ofs.quantity_received, ofs.date_sending, " +
			"ofs.total_price, m.id AS medication_id, m.name AS medication_name, m.pharmacy_price, mc.id AS medication_category_id, " +
			"mc.name AS medication_category_name, m.prescription, m.stock_in_hand, m.maximum_stock, m.minimum_threshold_before_supply_order, " +
			"m.supplier_price, s.id AS supplier_id, s.name AS supplier_name " +
			"FROM order_from_supplier AS ofs " +
			"INNER JOIN medication AS m " +
			"ON ofs.medication_id = m.id " +
			"INNER JOIN medication_category AS mc " +
			"ON m.medication_category_id = mc.id " +
			"INNER JOIN supplier AS s " +
			"ON m.supplier_id = s.id " +
			"WHERE status = 'CREATED';"
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
		
			OrderFromSupplier orderFromSupplier = new OrderFromSupplier(
				rs.getInt("order_from_supplier_id"),
				medication,
				rs.getInt("quantity_ordered"),
				rs.getDouble("total_price"),
				rs.getString("status"),
				rs.getString("date_sending"),
				rs.getInt("quantity_received")
			);
			
			ordersNotSent.add(orderFromSupplier);
		}
		
		return ordersNotSent;
	}

	public void insertData(
		int medicationId,
		int quantityOrdered,
		double totalPrice,
		String status,
		String dateSending
	) throws SQLException 
	{
		PreparedStatement preparedStatement = this.connection.prepareStatement(
			"INSERT INTO order_from_supplier (medication_id, quantity_ordered, status, date_sending, total_price)" +
			"VALUES (?, ?, ?, ?, ?)"
		);
		
		preparedStatement.setInt(1, medicationId);
		preparedStatement.setInt(2, quantityOrdered);
		preparedStatement.setString(3, status);
		preparedStatement.setString(4, dateSending);
		preparedStatement.setDouble(5, totalPrice);
		
		preparedStatement.executeUpdate();
		preparedStatement.close();
	}
}
