package vendingmachine.domain.coin;

import static vendingmachine.Constants.*;

import java.util.Iterator;
import java.util.Map;

import vendingmachine.domain.MoneyRepository;

public class CoinRepository {
	private static MachineCoins coins;

	public static void setCoins() {
		coins = new MachineCoins();
	}

	public static MachineCoins getCoins() {
		return coins;
	}

	public static int getCoinCount(int coinAmount) {
		Coin coin = Coin.valueOf(COIN_PREFIX + coinAmount);
		return coins.getCoins().get(coin);
	}

	public static Map<Coin, Integer> getChangeCoins() {
		long lastMoney = MoneyRepository.getUserMoney();
		return removeZeroCoins(coins.getChangeCoins(lastMoney));
	}

	private static Map<Coin, Integer> removeZeroCoins(Map<Coin, Integer> coins) {
		Iterator<Coin> iterator = coins.keySet().iterator();
		if (iterator.hasNext()) {
			removeZeroEntity(coins, iterator);
		}
		return coins;
	}

	private static void removeZeroEntity(Map<Coin, Integer> coins, Iterator<Coin> iterator) {
		Coin coin = iterator.next();
		if (coins.get(coin) == 0) {
			coins.remove(coin);
		}
	}
}