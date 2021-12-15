package vendingmachine.controller;

import vendingmachine.service.ProductService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class ProductController {
	private ProductService productService = new ProductService();
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
}
