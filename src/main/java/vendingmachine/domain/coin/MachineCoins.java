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

	public Map<Coin, Integer> CoinMapFrom(long amount) {
		Map<Coin, Integer> coinMap = new LinkedHashMap<>();
		List<Coin> coins = Arrays.asList(Coin.values());
		for (Coin coin : coins) {
			coinMap.put(coin, 0);
			amount = addCoinAsPossible(coin, amount, coinMap);
		}
		return coinMap;
	}

	private long addCoinAsPossible(Coin coin, long amount, Map<Coin, Integer> coinMap) {
		while (coin.isNotBiggerThan(amount) && coinMap.get(coin) < coinList.get(coin)) {
			amount = coin.subtractFrom(amount);
			coinMap.replace(coin, coinMap.get(coin)+1);
		}
		return amount;
	}

	public Map<Coin, Integer> getCoinList() {
		return coinList;
	}
}
