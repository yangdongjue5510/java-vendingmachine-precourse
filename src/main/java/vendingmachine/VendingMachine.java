package vendingmachine;

import vendingmachine.controller.CoinController;
import vendingmachine.controller.InputMoneyController;
import vendingmachine.domain.InputMoney;

public class VendingMachine {
	private InputMoneyController inputMoneyController = new InputMoneyController();
	private CoinController coinController = new CoinController();
	public void run() {
		InputMoney inputMoney = inputMoneyController.inputMoneyFromUser();
		coinController.changeCoinFrom(inputMoney);
	}
}
