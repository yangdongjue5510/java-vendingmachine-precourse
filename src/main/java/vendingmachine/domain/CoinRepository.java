package vendingmachine.domain;

public class CoinRepository {
	private static ChangeCoins coins;

	public static void setCoins() {
		coins = new ChangeCoins();
	}
}
