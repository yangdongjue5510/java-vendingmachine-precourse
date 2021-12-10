package vendingmachine.controller;

public class MainController {
	public void control() {
		InputMoneyController inputMoneyController = new InputMoneyController();
		inputMoneyController.inputMoneyControl();
		CoinController coinController = new CoinController();
		coinController.makeRandomControl();
		new ProductController().inputProductControl();
		inputMoneyController.inputUserMoneyControl();
		new OrderController().order();
		coinController.changeControl();
	}
}
