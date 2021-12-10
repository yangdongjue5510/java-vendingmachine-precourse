package vendingmachine.controller;

import vendingmachine.domain.MoneyRepository;
import vendingmachine.domain.Order;
import vendingmachine.view.OrderView;

public class OrderController {
	public void order() {
		OrderView.showRemainMoneyView(MoneyRepository.getUserMoney());
		OrderView.askOrderView();
		inputOrder();
	}

	private void inputOrder() {
		Order order = new Order();
	}
}
