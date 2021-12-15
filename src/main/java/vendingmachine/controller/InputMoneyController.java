package vendingmachine.controller;

import vendingmachine.domain.InputMoney;

import vendingmachine.service.InputMoneyService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class InputMoneyController {
	private final InputMoneyService inputMoneyService = new InputMoneyService();

	public InputMoney inputMoneyFromUser() {
		String line = InputView.inputMachineMoneyView();
		InputMoney inputMoney = null;
		try {
			inputMoney = inputMoneyService.inputMoney(line);
		} catch (IllegalArgumentException exception) {
			OutputView.errorView(exception.getMessage());
			inputMoneyFromUser();
		}
		return  inputMoney;
	}

}
