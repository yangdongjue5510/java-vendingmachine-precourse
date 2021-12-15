package vendingmachine;

import vendingmachine.controller.CoinController;
import vendingmachine.controller.InputMoneyController;
import vendingmachine.controller.ProductController;
import vendingmachine.domain.Money;

public class VendingMachine {
	private InputMoneyController inputMoneyController = new InputMoneyController();
	private CoinController coinController = new CoinController();
	private ProductController productController = new ProductController();
	public void run() {
		machineInitialize();
		orderProcess();
	}

	private void machineInitialize() {
		Money inputMoney = inputMoneyController.inputMachineMoney();
		coinController.changeCoinFrom(inputMoney);
		productController.inputProducts();
	}

	private void orderProcess() {
		inputMoneyController.inputUserMoney();
		productController.orderProductUntilValid();
		coinController.changeCoinFromRemainUserMoney();
	}
}
