package vendingmachine;

import vendingmachine.controller.InputMoneyController;

public class VendingMachine {
	private InputMoneyController inputMoneyController = new InputMoneyController();

	public void run() {
		inputMoneyController.inputMoneyControl();
	}
}
