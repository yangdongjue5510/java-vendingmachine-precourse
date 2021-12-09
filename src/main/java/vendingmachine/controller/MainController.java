package vendingmachine.controller;

public class MainController {
	public void control() {
		InputMoneyController inputMoneyController = new InputMoneyController();
		CoinController coinController = new CoinController();
		inputMoneyController.inputMoneyControl();
		coinController.makeRandomControl();
		new ProductController().inputProductControl();
		inputMoneyController.inputUserMoneyControl();
		new OrderController().order();
		coinController.changeControl();
	}
}
