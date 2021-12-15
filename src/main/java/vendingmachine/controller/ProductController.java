package vendingmachine.controller;

import vendingmachine.service.MoneyService;
import vendingmachine.service.ProductService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class ProductController {
	private ProductService productService = new ProductService();
	private MoneyService moneyService = new MoneyService();

	public void inputProducts() {
		String productsLine;
		try {
			productsLine = InputView.inputProductLineView();
			productService.enrollProduct(productsLine);
		} catch (IllegalArgumentException exception) {
			OutputView.errorView(exception.getMessage());
			inputProducts();
		}
	}

	public void orderProductUntilValid() {
		while (!productService.isAllProductSoldOut() && moneyService.canBuyCheapestProduct()) {
			orderProduct();
		}
	}

	private void orderProduct() {
		try {
			OutputView.remainUserMoneyView(moneyService.getUserRemainMoney());
			productService.orderProduct(InputView.inputProductName());
		} catch (IllegalArgumentException exception) {
			OutputView.errorView(exception.getMessage());
			orderProduct();
		}
	}
}
