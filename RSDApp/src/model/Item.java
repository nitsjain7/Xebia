package model;

/**
 * @author niyatee.jain Item class for the items present in the bill
 *
 */
public class Item {

	private Price price;
	private String id;
	private String description;
	private String type; // to separate grocery and non-grocery items

	public String getDescription() {
		return description;
	}

	public String getId() {
		return id;
	}

	public Price getPrice() {
		return price;
	}

	public String getType() {
		return type;
	}

	/**
	 * Method to return current state of this Object instance (can be also achieved
	 * by overriding toString() method of Object class)
	 * 
	 * @return current state of this object properties
	 */
	public String printStatus() {
		return id + "," + description + "," + price.getAmount() + "," + price.getCurrency();
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public void setType(String type) {
		this.type = type;
	}
}