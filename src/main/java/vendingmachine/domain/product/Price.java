package vendingmachine.domain.product;

import static vendingmachine.Constants.*;

import vendingmachine.domain.common.PositiveNumber;

public class Price extends PositiveNumber {
	public Price(String inputLine) {
		super(inputLine);
		exceptionNotDivideTen(inputLine);
		exceptionUnderHundred(inputLine);
		setNumber(Long.parseLong(inputLine));
	}

	@Override
	public long getAmount() {
		return getNumber();
	}

	private void exceptionUnderHundred(String inputLine) {
		if (Long.parseLong(inputLine) < MIN_PRODUCT_PRICE) {
			throw new IllegalArgumentException();
		}
	}

	private void exceptionNotDivideTen(String inputLine) {
		if (Long.parseLong(inputLine) % DIVIDE_PRODUCT_PRICE != ZERO) {
			throw new IllegalArgumentException();
		}
	}
}
