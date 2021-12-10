package vendingmachine.controller;

public class MainController {
	InputMoneyController inputMoneyController = new InputMoneyController();
	CoinController coinController = new CoinController();

	public void control() {
		inputMoneyController.inputMoneyControl();
		coinController.makeRandomControl();
		new ProductController().inputProductControl();
		inputMoneyController.inputUserMoneyControl();
		new OrderController().order();
		coinController.changeControl();
	}
}
