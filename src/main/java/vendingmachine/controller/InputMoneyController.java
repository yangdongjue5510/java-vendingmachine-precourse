package vendingmachine.controller;

import vendingmachine.domain.Money;

import vendingmachine.service.MoneyService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class InputMoneyController {
	private final MoneyService moneyService = new MoneyService();

	public Money inputMachineMoney() {
		String line = InputView.inputMachineMoneyView();
		Money inputMoney;
		try {
			inputMoney = moneyService.inputMoney(line);
		} catch (IllegalArgumentException exception) {
			OutputView.errorView(exception.getMessage());
			inputMoney = inputMachineMoney();
		}
		return  inputMoney;
	}

	public Money getUserMoneyUntilValid() {
		String line = InputView.inputUserMoney();
		Money userMoney;
		try {
			userMoney = moneyService.inputMoney(line);
		} catch (IllegalArgumentException exception) {
			OutputView.errorView(exception.getMessage());
			userMoney = getUserMoneyUntilValid();
		}
		return userMoney;
	}

	public void inputUserMoney() {
		moneyService.saveMoney(getUserMoneyUntilValid());
	}
}
