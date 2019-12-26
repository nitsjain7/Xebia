package dao;

/**
 * Discount class to define common discount properties needed
 *
 */
public abstract class Discount {

	// discount percent applicable
	protected double discount_percent;

	// method to find the net payable amount after discount
	public double calculateNetAmount(double priceIntoConsideration) {
		return (priceIntoConsideration * (100 - discount_percent)) / 100;

	}

	// abstract method to set the discount percent for various users
	public abstract void getDiscountPercent();

}
