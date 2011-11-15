package beans;

import java.io.Serializable;

/**
 *
 * @author novaterata
 */
public class User implements Serializable{
	private String FirstName;
	private String LastName;
	public User() {
	}
	/**
	 * 
	 * @return 
	 */
	public String getLastName() {
		return LastName;
	}
	/**
	 * 
	 * @param LastName 
	 */
	public void setLastName(String LastName) {
		this.LastName = LastName;
	}
	/**
	 * 
	 * @return 
	 */
	public String getFirstName() {
		return FirstName;
	}
	/**
	 * 
	 * @param FirstName 
	 */
	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}
}
