package vendingmachine.domain.product;

import static vendingmachine.Constants.*;

import java.util.Arrays;
import java.util.List;

import vendingmachine.domain.Nameable;

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
		String name = validationName(information.get(0));
		Price price = new Price(information.get(1));
		Count count = new Count(information.get(2));
		return new Product(name, price, count);
	}

	public String getName() {
		return name;
	}

	public Price getPrice() {
		return price;
	}

	public PositiveNumber getCount() {
		return count;
	}

	public void consumeProduct() {
		count.consumeCount();
	}

	private static List<String> splitInformationComma(String productString) {
		return Arrays.asList(productString.substring(1, productString.length() - 1).split(COMMA));
	}

	private static void validationInformation(List<String> information) {
		if (information.size() != 3) {
			throw new IllegalArgumentException();
		}
	}
}