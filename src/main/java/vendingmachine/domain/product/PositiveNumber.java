package vendingmachine.domain.product;

import static vendingmachine.Constants.*;

import vendingmachine.view.ErrorView;

public class PositiveNumber {
	protected long number;

	public PositiveNumber() {}

	public PositiveNumber(String inputLine) {
		exceptionNotNumber(inputLine);
		exceptionEmpty(inputLine);
		exceptionZero(inputLine);
		number = Long.parseLong(inputLine);
	}

	public long getNumber() {
		return number;
	}

	private void exceptionNotNumber(String inputLine) {
		char[] chars = inputLine.toCharArray();
		for (char digit : chars) {
			exceptionCharNotNumber(digit);
		}
	}

	private void exceptionCharNotNumber(char digit) {
		if (digit > CHAR_MAX_NUMBER || digit < CHAR_MIN_NUMBER) {
			ErrorView.inputMoneyIsNotNumber();
			throw new IllegalArgumentException();
		}
	}

	private void exceptionEmpty(String inputLine) {
		if (inputLine.equals(EMPTY_STRING)) {
			ErrorView.inputMoneyEmpty();
			throw new IllegalArgumentException();
		}
	}

	private void exceptionZero(String inputLine) {
		if (inputLine.equals(STRING_ZERO)) {
			ErrorView.inputMoneyZero();
			throw new IllegalArgumentException();
		}
	}
}
