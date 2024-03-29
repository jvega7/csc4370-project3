/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package beans;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;
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
	private static final String SQL_TO_WRITE_OBJECT = "INSERT INTO ORDERS(userid, orderid, cart, timestamp) VALUES (?, NULL, ?, ?)";
    	private static final String SQL_TO_READ_OBJECT = "SELECT * FROM ORDERS WHERE userid = ?";
	private static final String SQL_TO_ADD_USER = "INSERT INTO CUSTOMERS(username, LastName, FirstName, Address, City, State, ZipCode, Phone, EMail, password, admin) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String SQL_TO_DECREASE_ITEM = "UPDATE critchea1.inventory SET quantity = quantity - 1 WHERE sku = ?";
	private static final String SQL_TO_CHECK_USERNAME_EXISTS = "select * from critchea1.customers where username=?";
	private static final String SQL_TO_UPDATE_USER = "UPDATE critchea1.customers SET LastName = ?, FirstName = ?, Address = ?, City = ?, State = ?, ZipCode = ?, Phone = ?, EMail = ?, password = ? WHERE username = ?";
		
	private static LinkedList<Timestamp> timestamps;

	public static LinkedList<Timestamp> getTimestamps() {
		return timestamps;
	}

	public static void setTimestamps(LinkedList<Timestamp> timestamps) {
		DB.timestamps = timestamps;
	}
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
		DB.dbCon = dbCon;
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
	private static Connection dbCon;
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
	public static long updateUser(User user) throws SQLException{
		PreparedStatement pstmt = dbCon.prepareStatement(SQL_TO_UPDATE_USER, Statement.RETURN_GENERATED_KEYS);
		pstmt.setString(1, user.getLastName());
		pstmt.setString(2, user.getFirstName());
		pstmt.setString(3, user.getAddress());
		pstmt.setString(4, user.getCity());
		pstmt.setString(5, user.getState());
		pstmt.setInt(6, user.getZipcode());
		pstmt.setString(7, ""+user.getPhone());
		pstmt.setString(8, user.getEmail());
		pstmt.setString(9, user.getPassword());
		pstmt.setString(10, user.getUsername());
		pstmt.executeUpdate();
		ResultSet rs = pstmt.getGeneratedKeys();
		int id = -1;
		if (rs.next()){
			id = rs.getInt(1);
		}
		rs.close();
		System.out.println(""+user.getUsername()+" updated in database.");
		return id;
	}
	public static long addUser(User user) throws SQLException{
		PreparedStatement pstmt = dbCon.prepareStatement(SQL_TO_ADD_USER, Statement.RETURN_GENERATED_KEYS);
		pstmt.setString(1, user.getUsername());
		pstmt.setString(2, user.getLastName());
		pstmt.setString(3, user.getFirstName());
		pstmt.setString(4, user.getAddress());
		pstmt.setString(5, user.getCity());
		pstmt.setString(6, user.getState());
		pstmt.setInt(7, user.getZipcode());
		pstmt.setString(8, ""+user.getPhone());
		pstmt.setString(9, user.getEmail());
		pstmt.setString(10, user.getPassword());
		pstmt.setBoolean(11, user.isAdmin());
		pstmt.executeUpdate();
		ResultSet rs = pstmt.getGeneratedKeys();
		int id = -1;
		if (rs.next()){
			id = rs.getInt(1);
		}
		rs.close();
		System.out.println(""+user.getUsername()+" added to database.");
		return id;
	}
 public static long writeCartList(String userid, Object object)
            throws Exception {
//        String className = object.getClass().getName();
        PreparedStatement pstmt = dbCon.prepareStatement(SQL_TO_WRITE_OBJECT, Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, userid);
        pstmt.setObject(2, object);
	pstmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
        pstmt.executeUpdate();
        ResultSet rs = pstmt.getGeneratedKeys();
        int id = -1;
        if (rs.next()) {
            id = rs.getInt(1);
        }
        rs.close();
        pstmt.close();
        System.out.println("Serialization Successful.");
	LinkedList<InventoryItem> cartList = (LinkedList<InventoryItem>) object;
	for(int i = 0; i < cartList.size(); i++){
		InventoryItem item = cartList.get(i);
		decreaseInventory(1, item.getSku());
	}
        return id;
    }
  /**
     * This class will de-serialize a java object from the database
     */
    public static LinkedList<LinkedList<InventoryItem>> readOrders(String userid)
            throws Exception {
        PreparedStatement pstmt = dbCon.prepareStatement(SQL_TO_READ_OBJECT);
        pstmt.setString(1, userid);
        ResultSet rs = pstmt.executeQuery();
	LinkedList<LinkedList<InventoryItem>> orders = new LinkedList();
	timestamps = new LinkedList();
        while(rs.next()){
	timestamps.add(rs.getTimestamp("timestamp"));
        byte[] buf = rs.getBytes("cart");
        ObjectInputStream objectIn = null;
        objectIn = new ObjectInputStream(new ByteArrayInputStream(buf));
	Object object = null;
        object = objectIn.readObject();
	LinkedList<InventoryItem> cartList = (LinkedList<InventoryItem>) object;
	orders.add(cartList);
	}
        rs.close();
        pstmt.close();
        System.out.println("Deserialization Successful.");
        return orders;
    }
    public static void decreaseInventory(int quantity, long sku) throws SQLException{
	PreparedStatement pstmt = dbCon.prepareStatement(SQL_TO_DECREASE_ITEM);
	pstmt.setLong(1, sku);
	for (;quantity > 0; quantity--){
		pstmt.executeUpdate();
	}
	pstmt.close();
	System.out.println(sku + " decreased " + quantity + " time(s).");
    }
    public static boolean usernameExists(String username) throws SQLException{
	    boolean exists = true;
	    PreparedStatement pstmt = dbCon.prepareStatement(SQL_TO_CHECK_USERNAME_EXISTS);
	    pstmt.setString(1, username);
	    ResultSet rs = pstmt.executeQuery();
	    if(rs.next()){
		    exists = true;
	    } else {
		    exists = false;
	    }
	    rs.close();
	    pstmt.close();
	    return exists;
    }
}
