package vendingmachine.repository;

import java.util.Map;

import vendingmachine.domain.coin.Coin;
import vendingmachine.domain.coin.MachineCoins;

public class CoinRepository {
	private static final CoinRepository coinRepository = new CoinRepository();
	private MachineCoins machineCoins;

	public static CoinRepository getInstance() {
		return coinRepository;
	}

	public void saveCoins(MachineCoins coins) {
		machineCoins = coins;
	}

	public Map<Coin, Integer> getCoinMap() {
		return machineCoins.getCoinList();
	}
}
