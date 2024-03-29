package beans;

import java.sql.Timestamp;
import java.util.LinkedList;

/**
 *
 * @author novaterata
 */
public class User{
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private int zipcode;
	private long phone;
	private String email;
	private LinkedList<LinkedList<InventoryItem>> orders;
	private LinkedList<Timestamp> timestamps;

	public LinkedList<Timestamp> getTimestamps() {
		return timestamps;
	}

	public void setTimestamps(LinkedList<Timestamp> timestamps) {
		this.timestamps = timestamps;
	}

	public LinkedList<LinkedList<InventoryItem>> getOrders() {
		return orders;
	}

	public void setOrders(LinkedList<LinkedList<InventoryItem>> orders) {
		this.orders = orders;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	private boolean valid;
	private boolean admin;

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

}
