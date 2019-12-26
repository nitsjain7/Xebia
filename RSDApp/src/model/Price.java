package model;

/**
 * @author niyatee.jain Price class for the items
 *
 */
public class Price {

	private double amount;
	private String currency;// JPY, USD,INR

	public double getAmount() {
		return amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}