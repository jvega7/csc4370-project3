/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.math.BigDecimal;

/**
 *
 * @author novaterata
 */
public class InventoryItem {
	private String description;
	private long sku;
	private String name;
	private double price;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	public long getSku() {
		return sku;
	}

	public void setSku(long sku) {
		this.sku = sku;
	}
}
