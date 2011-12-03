/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package beans;

import java.math.BigDecimal;
import java.util.LinkedList;

/**
 *
 * @author novaterata
 */
public class ShopingCart{
	private int orderid;
	private LinkedList<InventoryItem> cartList;
	private double total;

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public ShopingCart() {
	}

	public LinkedList<InventoryItem> getCartList() {
		return cartList;
	}

	public void setCartList(LinkedList<InventoryItem> cartList) {
		this.cartList = cartList;
	}

}
