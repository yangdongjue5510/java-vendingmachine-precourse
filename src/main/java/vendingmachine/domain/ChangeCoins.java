package vendingmachine.domain;

import static vendingmachine.Constants.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;

public class ChangeCoins {
	private Map<Coin, Integer> changeCoins = new LinkedHashMap<>();

	ChangeCoins() {
		long money = MoneyRepository.getMoney();
		setChangeCoins(money);
	}

	Map<Coin, Integer> getCoins() {
		return changeCoins;
	}

	private void setChangeCoins(long money) {
		List<Coin> coins = Arrays.asList(Coin.values());
		for (int i = 0; i <= UNTIL_FIFTY_WON_INDEX; i++) {
			int randomCount = getRandomCount(coins.get(i), money);
			money = calculateMoney(coins.get(i), randomCount, money);
			changeCoins.put(coins.get(i), randomCount);
		}
		changeCoins.put(Coin.COIN_10, getMAXCount(Coin.COIN_10, money));
	}

	private int getRandomCount(Coin coin, long money) {
		return Randoms.pickNumberInList(getRange(coin, money));
	}

	private int getMAXCount(Coin coin, long money) {
		return (int)(money / coin.getAmount());
	}

	private long calculateMoney(Coin coin, int count, long money) {
		return money - (coin.getAmount() * count);
	}

	private List<Integer> getRange(Coin coin, long money) {
		int amount = coin.getAmount();
		List<Integer> range = new ArrayList<>();
		int maxCount = (int)(money / amount);
		for (int i = 0; i <= maxCount; i++) {
			range.add(i);
		}
		return range;
	}
}
