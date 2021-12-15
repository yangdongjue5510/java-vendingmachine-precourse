package vendingmachine.domain.product;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import vendingmachine.domain.Money;

public class Product implements Comparable<Product>{
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

	public boolean nameIs(String inputProductName) {
		return this.name.equals(inputProductName);
	}

	public boolean canBuy(Money userRemainMoney) {
		return userRemainMoney.isNotSmallerThan(this.price);
	}

	public Product consume() {
		count.subtract();
		return this;
	}

	public Price getPrice() {
		return this.price;
	}

	public boolean soldOut() {
		return count.remainZero();
	}

	@Override
	public int compareTo(Product other) {
		return this.price.compareWith(other.price);
	}
}
