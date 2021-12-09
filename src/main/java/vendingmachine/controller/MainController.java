package vendingmachine.controller;

public class MainController {
	public void control() {
		new InputMoneyController().inputMoneyControl();
		new RandomCoinController().makeRandomControl();
		new ProductController().inputProductControl();
	}
}
