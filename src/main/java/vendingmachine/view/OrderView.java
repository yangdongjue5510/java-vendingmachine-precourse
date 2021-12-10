package vendingmachine.view;

import static vendingmachine.Constants.*;
import static vendingmachine.view.ConstantMessage.*;

public class OrderView {
	public static void orderStatementView() {
		System.out.println(MESSAGE_ORDER);
	}

	public static void showRemainMoneyView(long money) {
		System.out.println(MESSAGE_REMAIN_MONEY + money + WON);
	}

	public static void askOrderView() {
		System.out.println(MESSAGE_ASK_ORDER);
	}
}
