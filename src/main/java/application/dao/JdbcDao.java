package application.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;
import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@SuppressWarnings("restriction")
public class JdbcDao {
	private static DataSource dataSource = null;
	
	static {
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
		}
		catch (Exception e) {}
		
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:jtds:sqlserver://localhost:1433");
		config.setUsername("sa");
		config.setPassword("yourStrong(!)Password");
		config.setMaximumPoolSize(10);
		config.setAutoCommit(false);
		config.setConnectionTestQuery("SELECT 1");
		config.addDataSourceProperty("databaseName", "test");
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		dataSource = new HikariDataSource(config);
	}
	    
	public CachedRowSet query(String sql) {
		CachedRowSet results = null;
		try (Connection con = dataSource.getConnection();  
			 Statement stmt = con.createStatement(); 
			 ResultSet rs = stmt.executeQuery(sql)) {  
			
			results = new CachedRowSetImpl();
			results.populate(rs);
		}
		catch (Exception e) {  
			e.printStackTrace();
		}
	      
		return results;
	}
}
