package application;

import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Logger;

import controller.ItemManager;
import dao.Discount;
import dao.DiscountFactory;
import model.Item;

/**
 * @author niyatee.jain 'Retail Store Discount App' : The class providing an
 *         entry point to access a given bill in csv and determine the net
 *         payable amount.
 */
/**
 * @author niyatee.jain
 *
 */
public class RSDApp {

	// Load list of available items list
	static ItemManager itemManager = new ItemManager();
	static HashMap<String, Item> itemMap = null;
	static String privilege = "";
	static DiscountFactory discountFactory = new DiscountFactory();
	static double netPayableAmount;

	static Logger logger = Logger.getLogger(RSDApp.class.getName());

	/**
	 * @param itemMap
	 *            : the list of all items in the bill
	 * @return the total price of all the non-grocery items in the bill i.e. items
	 *         eligible for discount
	 */
	public static double calculatePriceOfNonGroceryItems(HashMap<String, Item> itemMap) {

		double price = 0.0;
		Iterator<String> iterator = itemMap.keySet().iterator();
		while (iterator.hasNext()) {
			Item item = itemMap.get(iterator.next());
			if ((item != null) && !item.getType().equalsIgnoreCase("Grocery")) {
				// including only non grocery items for price consideration for discount
				price += item.getPrice().getAmount();
			}
		}
		return price;

	}

	public static double getNetPayableAmount() {
		return netPayableAmount;
	}

	/**
	 * @param args
	 *            The main method to start the processing of the bill
	 */
	public static void main(String[] args) {

		itemMap = readBill(args[0]);
		double priceIntoConsideration = calculatePriceOfNonGroceryItems(itemMap);
		logger.info("Total price :" + priceIntoConsideration);

		Discount discount = discountFactory.getDiscountType(privilege);
		discount.getDiscountPercent();
		setNetPayableAmount(discount.calculateNetAmount(priceIntoConsideration));

		logger.info("Net payable amount (after discount)" + getNetPayableAmount());
		logger.info("Thank you for shopping with our store, Have a nice day !!! ");

	}

	/**
	 * @return Prints the list of all items in the bill on the console
	 */
	public static HashMap<String, Item> readBill(String filename) {

		itemMap = itemManager.getAllItems(filename);
		logger.info("Printing the bill given as a csv");
		Iterator<String> iterator = itemMap.keySet().iterator();

		logger.info("-----List of Items Purchased------[Item#, Description, Price, Currency]");

		while (iterator.hasNext()) {
			String temp = iterator.next();
			Item item = itemMap.get(temp);
			if (item == null) {
				privilege = temp;
			} else {
				logger.info(item.printStatus());
			}
		}
		return itemMap;
	}

	public static void setNetPayableAmount(double netPayableAmount) {
		RSDApp.netPayableAmount = netPayableAmount;
	}

}