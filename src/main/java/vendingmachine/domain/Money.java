package vendingmachine.domain;

import static vendingmachine.Constants.*;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.common.PositiveNumber;
import vendingmachine.view.ErrorView;

public class Money extends PositiveNumber {
	public Money() {
		String inputLine;
		do {
			inputLine = Console.readLine();
		} while (!validationNumber(inputLine));
		setNumber(Long.parseLong(inputLine));
	}

	public long getAmount() {
		return getNumber();
	}

	public long subtractMoney(long subtractAmount) {
		long resultAmount = getNumber() - subtractAmount;
		setNumber(resultAmount);
		return resultAmount;
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
}
