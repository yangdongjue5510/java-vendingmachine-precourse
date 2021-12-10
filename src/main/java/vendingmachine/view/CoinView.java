package vendingmachine.view;

import static vendingmachine.Constants.*;
import static vendingmachine.view.ConstantMessage.*;

public class CoinView {
	public static void coinCountStatementView() {
		System.out.println(MESSAGE_COIN);
	}
	public static void coinCountView(int coinAmount, int coinCount) {
		System.out.println(coinAmount+ WON + DASH_SPACE + coinCount + COUNT);
	}
}
