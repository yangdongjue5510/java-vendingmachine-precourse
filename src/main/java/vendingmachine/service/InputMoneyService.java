package vendingmachine.service;

import vendingmachine.domain.Money;
import vendingmachine.repository.MoneyRepository;

public class InputMoneyService {
	public Money inputMoney(String line) {
		Money.exceptionInvalidInputMoney(line);
		return Money.of(line);
	}

	public void saveMoney(Money money) {
		MoneyRepository.getInstance().setUserMoney(money);
	}
}
