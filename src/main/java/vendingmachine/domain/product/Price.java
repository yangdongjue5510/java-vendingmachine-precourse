package vendingmachine.domain.product;

import static vendingmachine.Constants.*;

public class Price extends PositiveNumber {
	public Price(String inputLine) {
		super(inputLine);
		exceptionNotDivideTen(inputLine);
		exceptionUnderHundred(inputLine);
		number = Long.parseLong(inputLine);
	}

	private void exceptionUnderHundred(String inputLine) {
		if (Long.parseLong(inputLine) < MIN_PRODUCT_PRICE) {
			throw new IllegalArgumentException();
		}
	}

	private void exceptionNotDivideTen(String inputLine) {
		if (Long.parseLong(inputLine) % DIVIDE_PRODUCT_PRICE != 0) {
			throw new IllegalArgumentException();
		}
	}
}
