package vendingmachine.controller;

import vendingmachine.domain.CoinRepository;
import vendingmachine.domain.MoneyRepository;
import vendingmachine.view.InputMoneyView;

public class InputMoneyController {
	public void inputMoneyControl() {
		InputMoneyView.messageInputMoney();
		inputMoney();
		makeRandomControl();
	}

	public void makeRandomControl() {
		CoinRepository.setCoins();
	}

	private void inputMoney() {
		MoneyRepository.setMoney();
	}
}
