package dao;

/**
 * Class to set discount percent for an affiliate
 *
 */
public class AffiliateDiscount extends Discount {

	@Override
	public void getDiscountPercent() {
		discount_percent = 10;
	}

}
