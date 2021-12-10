package vendingmachine.controller;

import java.util.Arrays;

import vendingmachine.domain.coin.Coin;
import vendingmachine.domain.coin.CoinRepository;
import vendingmachine.view.CoinView;

public class RandomCoinController {
	public void makeRandomControl() {
		CoinRepository.setCoins();
		printRandomCoin();
	}

	private void printRandomCoin() {
		CoinView.coinCountStatementView();
		Arrays.asList(Coin.values()).stream().forEach(coin -> {
			int coinCount = CoinRepository.getCoinCount(coin.getAmount());
			CoinView.coinCountView(coin.getAmount(), coinCount);
		});
	}
}
