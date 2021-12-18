package vendingmachine.domain.product;

import java.util.Arrays;
import java.util.List;

import vendingmachine.domain.Money;

public class Product implements Comparable<Product>{
	private ProductName name;
	private Price price;
	private Count count;

	private Product(ProductName name, Price price, Count count) {
		this.name = name;
		this.price = price;
		this.count = count;
	}

	public static Product of(String productLine) {
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
