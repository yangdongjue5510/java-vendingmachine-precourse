package vendingmachine.domain;

import vendingmachine.domain.product.ProductRepository;

public class OrderService {
	public static void executePayment(Order order) {
		MoneyRepository.subtractUserMoney(order.getOrderPrice());
		ProductRepository.consumeProduct(order);
	}
}
