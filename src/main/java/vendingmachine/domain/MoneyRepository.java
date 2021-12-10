package vendingmachine.domain;

public class MoneyRepository {
	private static Money vendingMachineMoney;
	private static Money userInputMoney;

	public static void setMoney() {
		vendingMachineMoney = new Money();
	}

	public static long getMoney() {
		return vendingMachineMoney.getMoney();
	}

	public static void setUserMoney() {
		userInputMoney = new Money();
	}

	public static long getUserMoney() {
		return userInputMoney.getMoney();
	}
}
