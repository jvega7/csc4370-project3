package beans;

import java.io.Serializable;

/**
 *
 * @author novaterata
 */
public class User implements Serializable{
	private String firstName;
	private String lastName;
	private String username;

	public String getUserName() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}
	
	public User() {
	}
	/**
	 * @return 
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param LastName 
	 */
	public void setLastName(String LastName) {
		this.lastName = LastName;
	}
	/**
	 * @return 
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param FirstName 
	 */
	public void setFirstName(String FirstName) {
		this.firstName = FirstName;
	}
}
