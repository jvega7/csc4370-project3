/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author novaterata
 */
public class DB{
	String DbUrl = "jdbc:mysql://localhost/critchea1";
	String username = "critchea1";
	String password = "peppep";
	String dbDriver = "com.mysql.jdbc.Driver";
	private Connection dbCon;
	public DB() {
		super();
	}
	public boolean connect() throws ClassNotFoundException,SQLException{ 
		Class.forName(dbDriver); 
		dbCon = DriverManager.getConnection(DbUrl,username,password);
		return true; 
	}
	public void close() throws SQLException {
		dbCon.close();
	}
	public ResultSet execSQL(String sql) throws SQLException{
		Statement s = dbCon.createStatement(); 
		ResultSet r = s.executeQuery(sql); 
		return (r == null) ? null : r; 
	}
	public int updateSQL(String sql) throws SQLException{   
		Statement s = dbCon.createStatement();
		int r = s.executeUpdate(sql);
		return (r == 0) ? 0 : r; 
	}
}
