package vendingmachine.service;

import vendingmachine.domain.Money;
import vendingmachine.domain.product.MachineProducts;
import vendingmachine.domain.product.Product;
import vendingmachine.repository.MachineProductsRepository;
import vendingmachine.repository.MoneyRepository;

public class MoneyService {
	public void saveMoney(Money money) {
		MoneyRepository.getInstance().setUserMoney(money);
	}

	public Money getUserRemainMoney() {
		return MoneyRepository.getInstance().getUserMoney();
	}

	public void subtractFrom(Product product) {
		MoneyRepository.getInstance().subtractMoneyOf(product.getPrice());
	}

	public boolean canBuyCheapestProduct() {
		Product cheapest = MachineProductsRepository.getInstance().findCheapestNotSoldOut();
		return getUserRemainMoney().isNotSmallerThan(cheapest.getPrice());
	}
}
