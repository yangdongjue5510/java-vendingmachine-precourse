package vendingmachine.service;

import vendingmachine.domain.InputMoney;

public class InputMoneyService {
	public InputMoney inputMoney(String line) {
		InputMoney.exceptionInvalidInputMoney(line);
		return InputMoney.of(line);
	}
}
