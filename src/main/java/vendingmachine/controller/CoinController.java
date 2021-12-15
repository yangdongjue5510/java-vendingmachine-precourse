package vendingmachine.controller;

import vendingmachine.domain.Money;
import vendingmachine.service.CoinService;
import vendingmachine.view.OutputView;

public class CoinController {
	private CoinService coinService = new CoinService();

	public void changeCoinFrom(Money inputMoney) {
		coinService.makeCoinBy(inputMoney);
		OutputView.machineCoinView(coinService.machineCoinMap());
	}
}
