package application.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDao {
	private	Connection con = null;  
    private Statement stmt = null;  
    private ResultSet rs = null; 
	
	public ResultSet query(String sql) {
		// Create a variable for the connection string.  
		String connectionUrl = "jdbc:sqlserver://localhost:1433;" +  
	         "databaseName=test;user=sa;password=yourStrong(!)Password";  

		try {  
			// Establish the connection.  
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
			con = DriverManager.getConnection(connectionUrl);  
			stmt = con.createStatement(); 
			rs = stmt.executeQuery(sql);  
		}

		// Handle any errors that may have occurred.  
		catch (Exception e) {  
			e.printStackTrace();
		}
	      
		return rs;
	}
	
	public void cleanup() {
		if (stmt != null) try { stmt.close(); } catch(Exception e) {}  
        if (con != null) try { con.close(); } catch(Exception e) {}  
		if (rs != null) try { rs.close(); } catch (Exception e) {}
	}
}
