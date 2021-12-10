package vendingmachine.controller;

import vendingmachine.domain.MoneyRepository;
import vendingmachine.view.InputMoneyView;
import vendingmachine.view.OrderView;

public class InputMoneyController {
	public void inputMoneyControl() {
		InputMoneyView.messageInputMoney();
		inputMoney();
	}

	public void inputUserMoneyControl() {
		OrderView.orderStatementView();
		inputUserMoney();
	}

	private void inputMoney() {
		MoneyRepository.initializeMachineMoney();
	}

	private void inputUserMoney() {
		MoneyRepository.initializeUserMoney();
	}
}
