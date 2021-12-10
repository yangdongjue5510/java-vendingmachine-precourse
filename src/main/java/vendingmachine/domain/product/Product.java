package vendingmachine.domain.product;

import static vendingmachine.Constants.*;

import java.util.Arrays;
import java.util.List;

import vendingmachine.domain.common.Nameable;
import vendingmachine.domain.common.PositiveNumber;

public class Product extends Nameable {
	private String name;
	private Price price;
	private Count count;

	private Product(String name, Price price, Count count) {
		this.name = name;
		this.price = price;
		this.count = count;
	}

	public static Product makeProduct(String productString) throws IllegalArgumentException {
		List<String> information = splitInformationComma(productString);
		validationInformation(information);
		String name = validationName(information.get(NAME_INDEX));
		Price price = new Price(information.get(PRICE_INDEX));
		Count count = new Count(information.get(COUNT_INDEX));
		return new Product(name, price, count);
	}

	public String getName() {
		return name;
	}

	public long getPrice() {
		return price.getAmount();
	}

	public long getCount() {
		return count.getAmount();
	}

	public void consumeProduct() {
		count.consumeCount();
	}

	public boolean isNotEmpty() {
		return getCount() > ZERO;
	}

	private static List<String> splitInformationComma(String productString) {
		return Arrays
			.asList(productString.substring(PRODUCT_START_INDEX, productString.length() - PRODUCT_END_INDEX)
			.split(COMMA));
	}

	private static void validationInformation(List<String> information) {
		if (information.size() != PRODUCT_INFORMATION_COUNT) {
			throw new IllegalArgumentException();
		}
	}
}
