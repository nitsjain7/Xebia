package test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

import application.RSDApp;
import dao.Discount;
import dao.DiscountFactory;
import model.Item;
import model.Price;

public class TestPOS {
	@Test
	public void testCalculateNetAmount() {

		HashMap<String, Item> itemMap = new HashMap<String, Item>();
		Item item = new Item();
		Price price = new Price();
		item.setDescription("Milk");
		item.setId("i1");
		price.setAmount(220);
		price.setCurrency("USD");
		item.setPrice(price);
		item.setType("Grocery");
		Item item2 = new Item();
		Price price2 = new Price();
		item2.setDescription("Bread");
		item2.setId("i2");
		price2.setAmount(50);
		price2.setCurrency("USD");
		item2.setPrice(price2);
		item2.setType("Grocery");
		Item item3 = new Item();
		Price price3 = new Price();
		item3.setDescription("Butter");
		item3.setId("i3");
		price3.setAmount(20);
		price3.setCurrency("USD");
		item3.setPrice(price3);
		item3.setType("NonGroc");
		itemMap.put(item.getId(), item);
		itemMap.put(item2.getId(), item2);
		itemMap.put(item3.getId(), item3);

		double priceIntoConsideration = RSDApp.calculatePriceOfNonGroceryItems(itemMap);
		assertEquals(20.0, priceIntoConsideration, 0.0);

		DiscountFactory discountFactory = new DiscountFactory();
		Discount discount = discountFactory.getDiscountType("Employee");
		discount.getDiscountPercent();
		assertEquals(14.0, discount.calculateNetAmount(priceIntoConsideration), 0.0);

	}

	@Test
	public void testcalculatePrice() {
		HashMap<String, Item> itemMap = new HashMap<String, Item>();
		Item item = new Item();
		Price price = new Price();
		item.setDescription("Milk");
		item.setId("i1");
		price.setAmount(220);
		price.setCurrency("USD");
		item.setPrice(price);
		item.setType("Grocery");
		Item item2 = new Item();
		Price price2 = new Price();
		item2.setDescription("Bread");
		item2.setId("i2");
		price2.setAmount(50);
		price2.setCurrency("USD");
		item2.setPrice(price2);
		item2.setType("Grocery");
		Item item3 = new Item();
		Price price3 = new Price();
		item3.setDescription("Butter");
		item3.setId("i3");
		price3.setAmount(20);
		price3.setCurrency("USD");
		item3.setPrice(price3);
		item3.setType("NonGroc");
		itemMap.put(item.getId(), item);
		itemMap.put(item2.getId(), item2);
		itemMap.put(item3.getId(), item3);

		assertEquals(20.0, RSDApp.calculatePriceOfNonGroceryItems(itemMap), 0.0);
	}

	@Test
	public void testExcludeGroceries() {
		String[] filename = { "itemmaster.csv" };
		RSDApp.main(filename);
		assertEquals(189.0, RSDApp.getNetPayableAmount(), 0.0);
	}

	@Test
	public void testFiveDollarDiscount() {
		String[] filename = { "itemmaster.csv" };
		RSDApp.main(filename);
		assertEquals(189.0, RSDApp.getNetPayableAmount(), 0.0);
	}

	@Test
	public void testFivePerDiscount() {
		String[] filename = { "itemmaster.csv" };
		RSDApp.main(filename);
		assertEquals(189.0, RSDApp.getNetPayableAmount(), 0.0);
	}

	@Test
	public void testOneTypeDiscount() {
		String[] filename = { "itemmaster.csv" };
		RSDApp.main(filename);
		assertEquals(189.0, RSDApp.getNetPayableAmount(), 0.0);
	}

	@Test
	public void testReadBill() {
		String filename = "itemmaster.csv";
		HashMap<String, Item> itemMap = RSDApp.readBill(filename);
		assertEquals(4, itemMap.size());
	}

	@Test
	public void testTenPerDiscount() {
		String[] filename = { "itemmaster.csv" };
		RSDApp.main(filename);
		assertEquals(189.0, RSDApp.getNetPayableAmount(), 0.0);
	}

	@Test
	public void testThirtyPerDiscount() {
		String[] filename = { "itemmaster.csv" };
		RSDApp.main(filename);
		assertEquals(189.0, RSDApp.getNetPayableAmount(), 0.0);
	}

}
