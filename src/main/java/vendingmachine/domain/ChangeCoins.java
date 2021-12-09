package vendingmachine.domain;

import static vendingmachine.Constants.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class ChangeCoins {
	private Map<Coin, Integer> changeCoins = new LinkedHashMap<>();

	ChangeCoins() {
		initializeChangeCoins();
		setChangeCoins(MoneyRepository.getMoney());
	}

	Map<Coin, Integer> getCoins() {
		return changeCoins;
	}

	private void initializeChangeCoins() {
		Arrays.stream(Coin.values()).forEach(coin -> {
			changeCoins.put(coin, 0);
		});
	}

	private void setChangeCoins(long money) {
		int selectedAmount = selectCoin();
		if (money - selectedAmount > 0) {
			addCoin(selectedAmount);
			setChangeCoins(money-selectedAmount);
		} else if (money - selectedAmount < 0) {
			setChangeCoins(money);
		} else if (money - selectedAmount == 0) {
			addCoin(selectedAmount);
		}
	}

	private void addCoin(int amount) {
		Coin coin = Coin.findCoinByAmount(amount);
		Integer count = changeCoins.get(coin);
		changeCoins.replace(coin, count+1);
	}

	private int selectCoin() {
		List<Integer> coins = Arrays.stream(Coin.values())
			.map(coin -> coin.getAmount()).collect(Collectors.toList());
		return Randoms.pickNumberInList(coins);
	}

}
