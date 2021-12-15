package vendingmachine.repository;

import vendingmachine.domain.Money;

public class MoneyRepository {
	private static final MoneyRepository repository = new MoneyRepository();
	private Money userMoney;

	public static MoneyRepository getInstance() {
		return repository;
	}

	public void setUserMoney(Money money) {
		userMoney = money;
	}
}
