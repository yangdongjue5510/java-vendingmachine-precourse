package vendingmachine.domain;

public class MoneyRepository {
	private static Money vendingMachineMoney;
	private static Money userInputMoney;

	public static void initializeMachineMoney() {
		vendingMachineMoney = new Money();
	}

	public static long getMachineMoney() {
		return vendingMachineMoney.getMoney();
	}

	public static void initializeUserMoney() {
		userInputMoney = new Money();
	}

	public static long getUserMoney() {
		return userInputMoney.getMoney();
	}

	public static void subtractUserMoney(long subtractAmount) {
		//TODO
		userInputMoney.subtractMoney(subtractAmount);
	}
}
