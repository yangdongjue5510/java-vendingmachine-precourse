package vendingmachine.controller;

import vendingmachine.domain.product.ProductRepository;
import vendingmachine.view.ProductView;

public class ProductController {
	public void inputProductControl() {
		ProductView.inputProductView();
		inputProduct();
	}

	private void inputProduct() {
		ProductRepository.setProductInformation();
	}
}
