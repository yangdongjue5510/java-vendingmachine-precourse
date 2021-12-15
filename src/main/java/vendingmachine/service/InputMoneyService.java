package vendingmachine.service;

import vendingmachine.domain.Money;

public class InputMoneyService {
	public Money inputMoney(String line) {
		Money.exceptionInvalidInputMoney(line);
		return Money.of(line);
	}
}
