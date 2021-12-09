package vendingmachine.domain;

public class MoneyRepository {
	private static Money vendingMachineMoney;
	private static Money userInputMoney;

	public static void initializeMachineMoney() {
		vendingMachineMoney = new Money();
	}

	public static long getMachineMoney() {
		return vendingMachineMoney.getAmount();
	}

	public static void initializeUserMoney() {
		userInputMoney = new Money();
	}

	public static long getUserMoney() {
		return userInputMoney.getAmount();
	}

	public static void subtractUserMoney(long subtractAmount) {
		userInputMoney.subtractMoney(subtractAmount);
	}
}
