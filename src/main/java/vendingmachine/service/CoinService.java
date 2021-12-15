package vendingmachine.service;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import vendingmachine.domain.Money;
import vendingmachine.domain.coin.Coin;
import vendingmachine.domain.coin.MachineCoins;
import vendingmachine.repository.CoinRepository;
import vendingmachine.repository.MoneyRepository;

public class CoinService {
	public void makeCoinBy(Money inputMoney) {
		MachineCoins machineCoins = MachineCoins.of(inputMoney.getMoney());
		CoinRepository.getInstance().saveCoins(machineCoins);
	}

	public Map<Coin, Integer> machineCoinMap() {
		return CoinRepository.getInstance().getCoinMap();
	}

	public Map<Coin, Integer> getCoinsFromRemainMoney() {
		Map<Coin, Integer> changeCoinMap = CoinRepository.getInstance()
			.getChangeCoinMap(MoneyRepository.getInstance().getUserMoney().getMoney());
		return removeZeroCount(changeCoinMap);
	}

	private Map<Coin, Integer> removeZeroCount(Map<Coin, Integer> map) {
		Iterator<Coin> iterator = map.keySet().iterator();
		while(iterator.hasNext()) {
			removeZero(map, iterator);
		}
		return map;
	}

	private void removeZero(Map<Coin, Integer> map, Iterator<Coin> iterator) {
		Coin coin = iterator.next();
		if (map.get(coin) == 0) {
			iterator.remove();
		}
	}
}
