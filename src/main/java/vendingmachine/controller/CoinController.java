package vendingmachine.controller;

import vendingmachine.domain.Money;
import vendingmachine.service.CoinService;
import vendingmachine.service.MoneyService;
import vendingmachine.view.OutputView;

public class CoinController {
	private CoinService coinService = new CoinService();
	private MoneyService moneyService = new MoneyService();
	public void changeCoinFrom(Money inputMoney) {
		coinService.makeCoinBy(inputMoney);
		OutputView.machineCoinView(coinService.machineCoinMap());
	}

	public void changeCoinFromRemainUserMoney() {
		OutputView.remainUserMoneyView(moneyService.getUserRemainMoney());
		OutputView.changeCoinView(coinService.getCoinsFromRemainMoney());
	}
}
