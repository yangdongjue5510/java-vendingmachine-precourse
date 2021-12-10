package vendingmachine.domain.coin;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.MoneyRepository;

public class MachineCoins {
	private Map<Coin, Integer> machineCoins = new LinkedHashMap<>();

	MachineCoins() {
		initializeChangeCoins();
		setMachineCoins(MoneyRepository.getMachineMoney());
	}

	Map<Coin, Integer> getCoins() {
		return machineCoins;
	}

	public Map<Coin, Integer> getChangeCoins(long amount) {
		Map<Coin, Integer> changeCoins = new LinkedHashMap<>();
		List<Coin> coins = Arrays.asList(Coin.values());
		for (Coin coin : coins) {
			changeCoins.put(coin, countChangeCoin(coin, amount));
			subtractChangeFromCoin(coin, amount);
		}
		return changeCoins;
	}


	private long subtractChangeFromCoin(Coin coin, long amount) {
		return amount - (countChangeCoin(coin, amount) * coin.getAmount());
	}

	private int countChangeCoin(Coin coin, long amount) {
		if (amount < coin.getAmount()) {
			return 0;
		}
		if (amount / coin.getAmount() > machineCoins.get(coin)) {
			return machineCoins.get(coin);
		}
		return (int)(amount / coin.getAmount());
	}

	private void initializeChangeCoins() {
		Arrays.stream(Coin.values()).forEach(coin -> {
			machineCoins.put(coin, 0);
		});
	}

	private void setMachineCoins(long money) {
		int selectedAmount = selectCoin();
		if (money - selectedAmount > 0) {
			addCoin(selectedAmount);
			setMachineCoins(money-selectedAmount);
		} else if (money - selectedAmount < 0) {
			setMachineCoins(money);
		} else if (money - selectedAmount == 0) {
			addCoin(selectedAmount);
		}
	}

	private void addCoin(int amount) {
		Coin coin = Coin.findCoinByAmount(amount);
		Integer count = machineCoins.get(coin);
		machineCoins.replace(coin, count+1);
	}

	private int selectCoin() {
		List<Integer> coins = Arrays.stream(Coin.values())
			.map(coin -> coin.getAmount()).collect(Collectors.toList());
		return Randoms.pickNumberInList(coins);
	}

}
