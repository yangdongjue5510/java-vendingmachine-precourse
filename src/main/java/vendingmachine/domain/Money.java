package vendingmachine.domain;

import vendingmachine.domain.product.Price;

public class Money {

	private long money;

	private Money(String line) {
		money = Long.parseLong(line);
	}

	public static Money of(String line) {
		return new Money(line);
	}

	public long getMoney() {
		return money;
	}

	@Override
	public String toString() {
		return money + "원";
	}

	public void subtractOf(Price price) {
		money = price.subtractFrom(money);
	}

	public boolean isNotSmallerThan(Price price) {
		if (price.subtractFrom(money) >=0) {
			return true;
		}
		return false;
	}
}
