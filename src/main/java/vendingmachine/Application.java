package vendingmachine;

import vendingmachine.controller.MainController;

public class Application {
	public static void main(String[] args) {
		new MainController().control();
	}
}
