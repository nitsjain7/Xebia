package dao;

/**
 * Class to determine the kind of discount applicable depending upon the
 * privilege
 *
 */
public class DiscountFactory {

	/**
	 * @param privilege
	 * @return the discount percent on the basis of privilege
	 */
	public Discount getDiscountType(String privilege) {

		if (privilege == null) {
			return null;
		} else if (privilege.equalsIgnoreCase("Employee")) {
			return new EmployeeDiscount();
		} else if (privilege.equalsIgnoreCase("Affiliate")) {
			return new AffiliateDiscount();
		} else if (privilege.equalsIgnoreCase("Customer")) {
			return new EmployeeDiscount();
		} // if none of the above percent based discounts
		else {
			return new DefaultDiscount();
		}
	}
}
