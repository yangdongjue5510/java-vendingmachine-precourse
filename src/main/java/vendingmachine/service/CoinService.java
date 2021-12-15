package vendingmachine.service;

import java.util.Map;

import vendingmachine.domain.InputMoney;
import vendingmachine.domain.coin.Coin;
import vendingmachine.domain.coin.MachineCoins;
import vendingmachine.repository.CoinRepository;

public class CoinService {
	public void makeCoinBy(InputMoney inputMoney) {
		MachineCoins machineCoins = MachineCoins.of(inputMoney.getInputMoney());
		CoinRepository.getInstance().saveCoins(machineCoins);
	}

	public Map<Coin, Integer> machineCoinMap() {
		return CoinRepository.getInstance().getCoinMap();
	}
}
