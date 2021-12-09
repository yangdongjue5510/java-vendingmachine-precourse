package vendingmachine.domain;

import static vendingmachine.Constants.*;

import java.util.Arrays;
import java.util.List;

public class Product {
	private String name;
	private Price price;
	private PositiveNumber count;

	private Product(String name, Price price, PositiveNumber count) {
		this.name = name;
		this.price = price;
		this.count = count;
	}

	public static Product makeProduct(String productString) throws IllegalArgumentException {
		List<String> information = splitInformationComma(productString);
		validationInformation(information);
		String name = validationName(information.get(0));
		Price price = new Price(information.get(1));
		PositiveNumber count = new PositiveNumber(information.get(2));
		return new Product(name, price, count);
	}

	private static List<String> splitInformationComma(String productString) {
		return Arrays.asList(productString.substring(1, productString.length() - 1).split(COMMA));
	}

	private static void validationInformation(List<String> information) {
		if (information.size() != 3) {
			throw new IllegalArgumentException();
		}
	}

	private static String validationName(String name) {
		exceptionEmptyName(name);
		return name;
	}

	private static void exceptionEmptyName(String name) {
		if (name.equals(EMPTY_STRING)) {
			throw new IllegalArgumentException();
		}
	}
}
