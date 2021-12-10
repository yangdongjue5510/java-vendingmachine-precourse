package vendingmachine.controller;

import vendingmachine.domain.MoneyRepository;
import vendingmachine.domain.Order;
import vendingmachine.domain.OrderService;
import vendingmachine.domain.product.ProductRepository;
import vendingmachine.view.OrderView;

public class OrderController {
	public void order() {
		executeOrder();
	}

	private Order inputOrder() {
		return new Order();
	}

	private void purchaseOrder(Order order) {
		OrderService.executePayment(order);
	}

	private void executeOrder() {
		//TODO
		while (ProductRepository.checkPayable()) {
			OrderView.showRemainMoneyView(MoneyRepository.getUserMoney());
			OrderView.askOrderView();
			purchaseOrder(inputOrder());
		}
	}
}
