package vendingmachine.view;

import static vendingmachine.Constants.*;

public class CoinView {
	public static void coinCountView(int coinAmount, int coinCount) {
		System.out.println(coinAmount + DASH_SPACE + coinCount + COUNT);
	}
}
