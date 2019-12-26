package dao;

/**
 * Class to set discount percent for a customer
 *
 */
public class CustomerDiscount extends Discount {

	@Override
	public void getDiscountPercent() {
		discount_percent = 5;
	}

}
