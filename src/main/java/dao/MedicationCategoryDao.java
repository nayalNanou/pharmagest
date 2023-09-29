package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entity.MedicationCategory;

public class MedicationCategoryDao extends ConnectionDatabase {
	public ArrayList<MedicationCategory> getList() throws SQLException
	{
		ArrayList<MedicationCategory> medicationCategories = new ArrayList<MedicationCategory>();
		this.statement = this.connection.createStatement();
		ResultSet rs = this.statement.executeQuery("SELECT * FROM medication_category");
		
		while (rs.next()) {
			MedicationCategory medicationCategory = new MedicationCategory(
				rs.getInt("id"),
				rs.getString("name")
			);
			medicationCategories.add(medicationCategory);
		}
		
		return medicationCategories;
	}
}
