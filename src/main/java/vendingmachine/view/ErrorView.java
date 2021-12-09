package vendingmachine.view;

import static vendingmachine.view.ConstantMessage.*;

public class ErrorView {
	public static void inputMoneyIsNotNumber() {
		System.out.println(ERROR_INPUT_MONEY_NOT_NUMBER);
	}

	public static void inputMoneyEmpty() {
		System.out.println(ERROR_INPUT_MONEY_EMPTY);
	}
}
