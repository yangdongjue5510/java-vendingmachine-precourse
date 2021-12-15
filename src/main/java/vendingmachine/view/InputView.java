package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String MESSAGE_INPUT_MACHINE_MONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String MESSAGE_INPUT_PRODUCT_LINE = "상품명과 가격, 수량을 입력해 주세요.";
	private static final String MESSAGE_INPUT_USER_MONEY = "투입 금액을 입력해 주세요.";

	public static String inputMachineMoneyView() {
		System.out.println(MESSAGE_INPUT_MACHINE_MONEY);
		return Console.readLine();
	}

	public static String inputProductLineView() {
		System.out.println(MESSAGE_INPUT_PRODUCT_LINE);
		return Console.readLine();
	}

	public static String inputUserMoney() {
		System.out.println(MESSAGE_INPUT_USER_MONEY);
		return Console.readLine();
	}
}
