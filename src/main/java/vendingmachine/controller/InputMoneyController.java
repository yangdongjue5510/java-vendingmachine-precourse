package vendingmachine.controller;

import vendingmachine.domain.Money;

import vendingmachine.service.InputService;
import vendingmachine.service.MoneyService;
import vendingmachine.validator.MoneyValidator;
import vendingmachine.view.InputView;

public class InputMoneyController {
	private final MoneyService moneyService = new MoneyService();

	public Money inputMachineMoney() {
		InputView.inputMachineMoneyView();
		return Money.of(InputService.input(new MoneyValidator()));
	}

	public Money getUserMoneyUntilValid() {
		InputView.inputUserMoney();
		return Money.of(InputService.input(new MoneyValidator()));
	}

	public void inputUserMoney() {
		moneyService.saveMoney(getUserMoneyUntilValid());
	}
}
