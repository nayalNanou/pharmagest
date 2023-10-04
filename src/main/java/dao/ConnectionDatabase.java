package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDatabase {
	Connection connection;
	Statement statement;
	PreparedStatement preparedStatement;

	public ConnectionDatabase()
	{
      this.connection = null;
      try {
         Class.forName("org.postgresql.Driver");
         this.connection = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/pharmagest",
            "postgres", "woshinanou");
         this.connection.setAutoCommit(false);
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
      }
	}
	
	public void closeConnection()
	{
	 	try {
			this.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
