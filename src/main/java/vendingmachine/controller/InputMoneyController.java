package vendingmachine.controller;

import vendingmachine.domain.MoneyRepository;
import vendingmachine.view.InputMoneyView;

public class InputMoneyController {
	public void inputMoneyControl() {
		InputMoneyView.messageInputMoney();
		inputMoney();
	}

	private void inputMoney() {
		MoneyRepository.setMoney();
	}
}
