package vendingmachine.domain.product;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Product {
	private static final String ERROR_INVALID_FORMAT = "잘못된 상품 형식입니다.";
	private static Pattern pattern = Pattern.compile("^\\[[가-힣a-zA-Z0-9]+,[0-9]{3,},[0-9]+\\]$");
	private ProductName name;
	private Price price;
	private Count count;

	private Product(ProductName name, Price price, Count count) {
		this.name = name;
		this.price = price;
		this.count = count;
	}

	public static Product of(String productLine) {
		exceptionInvalidFormat(productLine);
		return productOf(productElementsOf(productLine));
	}

	private static List<String> productElementsOf(String productLine) {
		productLine = productLine.substring(1, productLine.length()-1);
		return Arrays.asList(productLine.split(","));
	}

	private static Product productOf(List<String> elements) {
		ProductName name = ProductName.of(elements.get(0));
		Price price = Price.of(elements.get(1));
		Count count = Count.of(elements.get(2));
		return new Product(name, price, count);
	}
	private static void exceptionInvalidFormat(String productsLine) {
		Matcher matcher = pattern.matcher(productsLine);
		if (!matcher.matches()) {
			throw new IllegalArgumentException(ERROR_INVALID_FORMAT);
		}
	}


}
