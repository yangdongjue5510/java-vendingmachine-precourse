package vendingmachine.controller;

import java.util.Arrays;
import java.util.Map;

import vendingmachine.domain.MoneyRepository;
import vendingmachine.domain.coin.Coin;
import vendingmachine.domain.coin.CoinRepository;
import vendingmachine.view.CoinView;
import vendingmachine.view.OrderView;

public class CoinController {
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

	public void changeControl() {
		OrderView.showRemainMoneyView(MoneyRepository.getUserMoney());
		CoinView.changeCoinStatementView();
		Map<Coin, Integer> changeCoins = CoinRepository.getChangeCoins();
		for (Map.Entry<Coin, Integer> entry : changeCoins.entrySet()) {
			CoinView.coinCountView(entry.getKey().getAmount(), entry.getValue());
		}
	}
}
