package vendingmachine.domain.product;

import vendingmachine.validator.MoneyValidator;

public class Price {
	private static final String ERROR_NOT_MULTI_TEN = "십의 배수를 입력하세요";
	private static final String ERROR_PRICE_ZERO = "가격이 0이되면 안됩니다.";
	private int price;

	private Price(int price) {
		this.price = price;
	}

	public static Price of(String string) {
		new MoneyValidator().exceptionInvalid(string);
		return new Price(Integer.parseInt(string));
	}

	public long subtractFrom(long money) {
		return money - price;
	}

	public int compareWith(Price other) {
		return this.price - other.price;
	}
}
