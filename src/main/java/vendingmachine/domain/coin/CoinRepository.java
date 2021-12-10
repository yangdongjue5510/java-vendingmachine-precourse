package vendingmachine.domain.coin;

import static vendingmachine.Constants.*;

public class CoinRepository {
	private static ChangeCoins coins;

	public static void setCoins() {
		coins = new ChangeCoins();
	}

	public static ChangeCoins getCoins() {
		return coins;
	}

	public static int getCoinCount(int coinAmount) {
		Coin coin = Coin.valueOf(COIN_PREFIX + coinAmount);
		return coins.getCoins().get(coin);
	}
}
