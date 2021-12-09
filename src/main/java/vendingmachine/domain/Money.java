package vendingmachine.domain;

import static vendingmachine.Constants.*;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.view.ErrorView;

public class Money {
	private long money;

	public Money() {
		String inputLine;
		do {
			inputLine = Console.readLine();
		} while (!validationNumber(inputLine));
		money = Long.parseLong(inputLine);
	}

	public long getMoney() {
		return money;
	}

	private boolean validationNumber(String inputLine) {
		try {
			exceptionNotNumber(inputLine);
			exceptionEmpty(inputLine);
			exceptionZero(inputLine);
			return true;
		} catch (IllegalArgumentException exception) {
			return false;
		}
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
