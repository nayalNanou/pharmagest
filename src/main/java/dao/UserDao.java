package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import entity.User;

public class UserDao extends ConnectionDatabase {
	public User findByUsername(String username) throws SQLException
	{
		User user = new User();
	
		String req = (
			"SELECT * FROM app_user WHERE username = ?;"
		);
        
        this.preparedStatement = this.connection.prepareStatement(req);
      	preparedStatement.setString(1, username);
      	ResultSet rs = preparedStatement.executeQuery();
      	
      	while (rs.next()) {
      		user.setId(rs.getInt("id"));
      		user.setUsername(rs.getString("username"));
      		user.setFullName(rs.getString("full_name"));
      		user.setPassword(rs.getString("password"));
      		user.setRole(rs.getString("role"));
      	}
      	
      	preparedStatement.close();
		
		return user;
	}
}
