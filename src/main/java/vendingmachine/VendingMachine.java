package vendingmachine;

import vendingmachine.controller.CoinController;
import vendingmachine.controller.InputMoneyController;
import vendingmachine.controller.ProductController;
import vendingmachine.domain.InputMoney;

public class VendingMachine {
	private InputMoneyController inputMoneyController = new InputMoneyController();
	private CoinController coinController = new CoinController();
	private ProductController productController = new ProductController();
	public void run() {
		InputMoney inputMoney = inputMoneyController.inputMoneyFromUser();
		coinController.changeCoinFrom(inputMoney);
		productController.inputProducts();
	}
}
