package vendingmachine.controller;

public class MainController {
	public void control() {
		InputMoneyController inputMoneyController = new InputMoneyController();
		inputMoneyController.inputMoneyControl();
		new RandomCoinController().makeRandomControl();
		new ProductController().inputProductControl();
		inputMoneyController.inputUserMoneyControl();
	}
}
