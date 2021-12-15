package vendingmachine.controller;

import vendingmachine.domain.Money;

import vendingmachine.service.InputMoneyService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class InputMoneyController {
	private final InputMoneyService inputMoneyService = new InputMoneyService();

	public Money inputMachineMoney() {
		String line = InputView.inputMachineMoneyView();
		Money inputMoney;
		try {
			inputMoney = inputMoneyService.inputMoney(line);
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
			userMoney = inputMoneyService.inputMoney(line);
		} catch (IllegalArgumentException exception) {
			OutputView.errorView(exception.getMessage());
			userMoney = getUserMoneyUntilValid();
		}
		return userMoney;
	}

	public void inputUserMoney() {
		inputMoneyService.saveMoney(getUserMoneyUntilValid());
	}
}
