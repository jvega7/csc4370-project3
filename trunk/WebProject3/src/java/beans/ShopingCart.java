/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package beans;

import java.util.LinkedList;

/**
 *
 * @author novaterata
 */
public class ShopingCart{
	private String userid;
	private int orderid;
	private User user;
	private LinkedList cart;
	private int total;

	public LinkedList getCart() {
		return cart;
	}

	public void setCart(LinkedList cart) {
		this.cart = cart;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	public ShopingCart() {
	}
}
