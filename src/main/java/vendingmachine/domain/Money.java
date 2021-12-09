package vendingmachine.domain;

import static vendingmachine.Constants.*;

import java.util.Locale;

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

	private boolean validationNumber(String inputLine) {
		try {
			exceptionNotNumber(inputLine);
			return true;
		} catch (IllegalArgumentException exception) {
			ErrorView.inputMoneyIsNotNumber();
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
			throw new IllegalArgumentException();
		}
	}

}
