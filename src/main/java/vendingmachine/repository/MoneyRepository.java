package vendingmachine.repository;

import vendingmachine.domain.Money;
import vendingmachine.domain.product.Price;

public class MoneyRepository {
	private static final MoneyRepository repository = new MoneyRepository();
	private Money userMoney;

	public static MoneyRepository getInstance() {
		return repository;
	}

	public void setUserMoney(Money money) {
		userMoney = money;
	}

	public Money getUserMoney() {
		return userMoney;
	}

	public void subtractMoneyOf(Price price) {
		userMoney.subtractOf(price);
	}
}
