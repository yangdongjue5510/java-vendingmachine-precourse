package vendingmachine.domain.product;

import static vendingmachine.Constants.*;

import vendingmachine.domain.common.PositiveNumber;

public class Count extends PositiveNumber {
	public Count(String inputLine) {
		super(inputLine);
	}

	@Override
	public long getAmount() {
		return getNumber();
	}

	public void consumeCount() {
		setNumber(getNumber() - PRODUCT_CONSUME_AMOUNT);
	}
}
