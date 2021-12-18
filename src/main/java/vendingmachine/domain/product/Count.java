package vendingmachine.domain.product;

import vendingmachine.validator.PositiveNumberValidator;

public class Count {
	private static final String ERROR_COUNT_ZERO = "갯수가 0이면 안됩니다.";
	private int count;

	private Count(int count) {
		this.count = count;
	}

	public static Count of(String string) {
		new PositiveNumberValidator().exceptionInvalid(string);
		return new Count(Integer.parseInt(string));
	}

	public void subtract() {
		count--;
	}

	public boolean remainZero() {
		return count == 0;
	}
}
