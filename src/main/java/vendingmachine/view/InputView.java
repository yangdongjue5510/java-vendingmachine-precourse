package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String MESSAGE_INPUT_MACHINE_MONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String MESSAGE_INPUT_PRODUCT_LINE = "상품명과 가격, 수량을 입력해 주세요.";
	private static final String MESSAGE_INPUT_USER_MONEY = "투입 금액을 입력해 주세요.";
	private static final String MESSAGE_INPUT_PRODUCT_NAME = "구매할 상품명을 입력해 주세요.";

	public static void inputMachineMoneyView() {
		System.out.println(MESSAGE_INPUT_MACHINE_MONEY);
	}

	public static void inputProductLineView() {
		System.out.println(MESSAGE_INPUT_PRODUCT_LINE);
	}

	public static void inputUserMoney() {
		System.out.println(MESSAGE_INPUT_USER_MONEY);
	}

	public static String inputProductName() {
		System.out.println(MESSAGE_INPUT_PRODUCT_NAME);
		return Console.readLine();
	}
}
