package vendingmachine.domain.common;

import static vendingmachine.Constants.*;

import vendingmachine.view.ErrorView;

public abstract class PositiveNumber {
	private long number;

	protected PositiveNumber() {
	}

	public abstract long getAmount();

	protected PositiveNumber(String inputLine) {
		exceptionNotNumber(inputLine);
		exceptionEmpty(inputLine);
		exceptionZero(inputLine);
		number = Long.parseLong(inputLine);
	}

	protected long getNumber() {
		return number;
	}

	protected void setNumber(long amount) {
		number = amount;
	}

	protected void exceptionNotNumber(String inputLine) {
		char[] chars = inputLine.toCharArray();
		for (char digit : chars) {
			exceptionCharNotNumber(digit);
		}
	}

	protected void exceptionCharNotNumber(char digit) {
		if (digit > CHAR_MAX_NUMBER || digit < CHAR_MIN_NUMBER) {
			ErrorView.inputMoneyIsNotNumber();
			throw new IllegalArgumentException();
		}
	}

	protected void exceptionEmpty(String inputLine) {
		if (inputLine.equals(EMPTY_STRING)) {
			ErrorView.inputMoneyEmpty();
			throw new IllegalArgumentException();
		}
	}

	protected void exceptionZero(String inputLine) {
		if (inputLine.equals(STRING_ZERO)) {
			ErrorView.inputMoneyZero();
			throw new IllegalArgumentException();
		}
	}
}
