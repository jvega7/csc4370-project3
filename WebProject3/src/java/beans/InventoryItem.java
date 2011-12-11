/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author novaterata
 */
public class InventoryItem implements Serializable{
	private String description;
	private long sku;
	private String name;
	private double price;
	private String path;
	private File f;
	private int available;

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public String getImage() {
		return "images/"+getSku()+".jpg";
	}

	public void setImage(String path, byte[] image) {
		FileOutputStream fw = null;
		f = null;
		try {
			f = new File(path+"/images/"+getSku()+".jpg");
			fw = new FileOutputStream(f);
			fw.write(image, 0, image.length);
			fw.close();
		} catch (IOException ex) {
			Logger.getLogger(InventoryItem.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

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
