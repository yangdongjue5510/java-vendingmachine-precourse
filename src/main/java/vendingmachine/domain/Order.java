package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.product.Product;
import vendingmachine.domain.product.ProductRepository;
import vendingmachine.view.ErrorView;

public class Order extends Nameable {
	private Product order;

	public Order() {
		String orderName;
		do {
			orderName = Console.readLine();
		} while (!validationOrder(orderName));
		order = ProductRepository.findProductsByName(orderName);
	}

	public long getOrderAmount(String orderName) {
		Product productsByName = ProductRepository.findProductsByName(orderName);
		return productsByName.getPrice().getNumber();
	}

	private boolean validationOrder(String order) {
		try {
			exceptionEmptyName(order);
			exceptionNotContain(order);
			exceptionOverPrice(order);
			return true;
		} catch (IllegalArgumentException exception) {
			ErrorView.invalidOrderView();
			return false;
		}
	}

	private void exceptionNotContain(String orderName) {
		if (ProductRepository.findProductsByName(orderName) == null) {
			throw new IllegalArgumentException();
		}
	}

	private void exceptionOverPrice(String orderName) {

		if (getOrderAmount(orderName) > MoneyRepository.getUserMoney()) {
			throw new IllegalArgumentException();
		}
	}
}
