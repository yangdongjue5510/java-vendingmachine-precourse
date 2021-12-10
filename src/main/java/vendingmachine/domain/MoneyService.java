package vendingmachine.domain;

import static vendingmachine.domain.MoneyRepository.*;

public class MoneyService {
	public static void subtractUserMoney(long subtractAmount) {
		long lastMoney = MoneyRepository.getUserMoney() - subtractAmount;
	}
}
