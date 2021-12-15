package vendingmachine.service;

import java.util.Map;

import vendingmachine.domain.Money;
import vendingmachine.domain.coin.Coin;
import vendingmachine.domain.coin.MachineCoins;
import vendingmachine.repository.CoinRepository;

public class CoinService {
	public void makeCoinBy(Money inputMoney) {
		MachineCoins machineCoins = MachineCoins.of(inputMoney.getMoney());
		CoinRepository.getInstance().saveCoins(machineCoins);
	}

	public Map<Coin, Integer> machineCoinMap() {
		return CoinRepository.getInstance().getCoinMap();
	}
}
