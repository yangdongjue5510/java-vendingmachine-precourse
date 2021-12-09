package vendingmachine.controller;

import vendingmachine.domain.CoinRepository;

public class RandomCoinController {
	public void makeRandomControl() {
		CoinRepository.setCoins();
	}
}
