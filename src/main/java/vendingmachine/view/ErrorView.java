package vendingmachine.view;

import static vendingmachine.view.ConstantMessage.*;

public class ErrorView {
	public static void inputMoneyIsNotNumber() {
		System.out.println(ERROR_INPUT_MONEY_NOT_NUMBER);
	}

	public static void inputMoneyEmpty() {
		System.out.println(ERROR_INPUT_MONEY_EMPTY);
	}

	public static void inputMoneyZero() {
		System.out.println(ERROR_INPUT_MONEY_ZERO);
	}

	public static void invalidProductInput() {
		System.out.println(ERROR_INVALID_PRODUCT_INPUT);
	}

	public static void invalidOrderView() {
		System.out.println(ERROR_INVALID_ORDER);
	}
}
