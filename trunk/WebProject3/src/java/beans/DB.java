/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package beans;

import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
/**
 *
 * @author novaterata
 */
public class DB{
	private String DbUrl = "jdbc:mysql://localhost/critchea1";
	private String username = "critchea1";
	private String password = "peppep";
	private String dbDriver = "com.mysql.jdbc.Driver";

	public String getDbUrl() {
		return DbUrl;
	}

	public void setDbUrl(String DbUrl) {
		this.DbUrl = DbUrl;
	}

	public Connection getDbCon() {
		return dbCon;
	}

	public void setDbCon(Connection dbCon) {
		this.dbCon = dbCon;
	}

	public String getDbDriver() {
		return dbDriver;
	}

	public void setDbDriver(String dbDriver) {
		this.dbDriver = dbDriver;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	private Connection dbCon;
	private LinkedList<InventoryItem> inventory;

	public LinkedList<InventoryItem> getInventory() {
		return inventory;
	}

	public void setInventory(LinkedList<InventoryItem> inventory) {
		this.inventory = inventory;
	}
	public DB() {
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
	public int updateSQLBytes(String sql, byte[] byteObject) throws SQLException{
		PreparedStatement ps = dbCon.prepareStatement(sql);
		Blob blob = dbCon.createBlob();
		blob.setBytes(1, byteObject);
		ps.setBlob(1, blob);
		int r = ps.executeUpdate(sql);
		return (r == 0) ? 0 :r;
	}
}
