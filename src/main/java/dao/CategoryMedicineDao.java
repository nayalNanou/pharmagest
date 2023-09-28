package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entity.CategoryMedicine;

public class CategoryMedicineDao extends ConnectionDatabase {
	public ArrayList<CategoryMedicine> getList() throws SQLException
	{
		ArrayList<CategoryMedicine> listCategoryMedicine = new ArrayList<CategoryMedicine>();
		this.statement = this.connection.createStatement();
		ResultSet rs = this.statement.executeQuery("SELECT * FROM category_medicine");
		
		while (rs.next()) {
			CategoryMedicine categoryMedicine = new CategoryMedicine(
				rs.getInt("id"),
				rs.getString("name")
			);
			listCategoryMedicine.add(categoryMedicine);
		}
		
		return listCategoryMedicine;
	}
}
