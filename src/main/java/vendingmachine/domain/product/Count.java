package vendingmachine.domain.product;

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
		setNumber(getNumber() - 1);
	}
}
