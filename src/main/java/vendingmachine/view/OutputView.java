package vendingmachine.view;

import java.util.Map;

import vendingmachine.domain.Money;
import vendingmachine.domain.coin.Coin;

public class OutputView {
	private static final String MESSAGE_USER_MONEY = "투입 금액: ";
	private static String ERROR = "[ERROR] ";
	private static String MESSAGE_MACHINE_MONEY = "\n자판기가 보유한 동전";
	private static String DASH_WITH_SPACE = " - ";
	private static String COIN_COUNT = "개";

	public static void errorView(String errorMessage) {
		System.out.println(ERROR + errorMessage);
	}

	public static void machineCoinView(Map<Coin, Integer> coins) {
		System.out.println(MESSAGE_MACHINE_MONEY);
		coinMapPrint(coins);
	}

	private static void coinMapPrint(Map<Coin, Integer> coins) {
		for (Map.Entry<Coin, Integer> entry : coins.entrySet()) {
			System.out.println(entry.getKey() + DASH_WITH_SPACE + entry.getValue() + COIN_COUNT);
		}
	}

	public static void remainUserMoneyView(Money money) {
		System.out.println(MESSAGE_USER_MONEY + money);
	}

	public static void changeCoinView(Map<Coin, Integer> coins) {
		System.out.println("잔돈");
		coinMapPrint(coins);
	}
}
