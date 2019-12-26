package dao;

/**
 * Class to set discount percent in case none of other percent based discounts
 * qualifies
 *
 */
public class DefaultDiscount extends Discount {

	@Override
	public void getDiscountPercent() {
		discount_percent = 5;
	}

}
