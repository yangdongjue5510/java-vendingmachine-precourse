package vendingmachine.domain.coin;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import camp.nextstep.edu.missionutils.Randoms;

public class MachineCoins {
	private Map<Coin, Integer> coinList = new LinkedHashMap<>();

	private MachineCoins(long amount) {
		initialize();
		setRandomCoinsFrom(amount);
	}

	public static MachineCoins of(long amount) {
		return new MachineCoins(amount);
	}

	private void initialize() {
		Arrays.asList(Coin.values())
			.stream().forEach(coin -> coinList.put(coin, 0));
	}


	private void setRandomCoinsFrom(long amount) {
		while (amount != 0) {
			int coinAmount = pickRandomCoin(amount);
			amount -= coinAmount;
			Coin coin = Coin.coinOf(coinAmount);
			coinList.replace(coin, coinList.get(coin)+1);
		}
	}

	private int pickRandomCoin(long amount) {
		int coinAmount;
		do {
			coinAmount = Randoms.pickNumberInList(Coin.coinAmountValues());
		} while (amount < coinAmount);
		return coinAmount;
	}

	private void setCoinsFrom(long amount) {
		List<Coin> coins = Arrays.asList(Coin.values());
		for (Coin coin : coins) {
			amount = addCoinAsPossible(coin, amount);
		}
	}

	private long addCoinAsPossible(Coin coin, long amount) {
		while (coin.isNotBiggerThan(amount)) {
			amount = coin.subtractFrom(amount);
			coinList.replace(coin, coinList.get(coin)+1);
		}
		return amount;
	}

	public Map<Coin, Integer> getCoinList() {
		return coinList;
	}
}
