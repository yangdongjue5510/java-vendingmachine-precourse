package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String MESSAGE_INPUT_MACHINE_MONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.";

	public static String inputMachineMoneyView() {
		System.out.println(MESSAGE_INPUT_MACHINE_MONEY);
		return Console.readLine();
	}
}