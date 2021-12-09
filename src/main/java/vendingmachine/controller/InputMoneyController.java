package vendingmachine.controller;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Money;
import vendingmachine.view.InputMoneyView;

public class InputMoneyController {
	public void control() {
		InputMoneyView.messageInputMoney();
		inputMoney();
	}

	private void inputMoney() {
		new Money();
	}
}
