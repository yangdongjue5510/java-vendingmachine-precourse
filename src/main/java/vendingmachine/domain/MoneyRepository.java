package vendingmachine.domain;

public class MoneyRepository {
	private static Money vendingMachineMoney;

	public static void setMoney() {
		vendingMachineMoney = new Money();
	}

	public static long getMoney() {
		return vendingMachineMoney.getMoney();
	}
}
