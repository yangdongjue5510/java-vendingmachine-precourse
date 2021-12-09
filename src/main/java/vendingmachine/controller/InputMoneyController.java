package vendingmachine.controller;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.view.InputMoneyView;

public class InputMoneyController {
	public void control() {
		InputMoneyView.messageInputMoney();
		inputMoney();
	}

	private long inputMoney() {
		return Long.parseLong(Console.readLine());
	}
}
