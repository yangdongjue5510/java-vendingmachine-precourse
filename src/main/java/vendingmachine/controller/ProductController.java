package vendingmachine.controller;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.model.MoneyModel;
import vendingmachine.model.ProductModel;
import vendingmachine.validator.MachineProductsValidator;
import vendingmachine.validator.OrderValidator;
import vendingmachine.view.MoneyView;
import vendingmachine.view.ProductView;

public class ProductController {
	public void inputProduct() {
		ProductView.messageInputProduct();
		ProductModel.enrollProducts(inputProductUntilValid());
	}

	public void orderProductUntilValid() {
		do {
			orderProduct();
		} while (ProductModel.canBuyProduct());
	}

	private void orderProduct() {
		MoneyView.printLastUserMoney(MoneyModel.getUserMoney());
		ProductView.messageOrderProduct();
		ProductModel.buyProduct(orderProductNameUntilValid());
	}

	private String inputProductUntilValid() {
		String inputProductLine;
		do {
			inputProductLine = Console.readLine();
		} while (!MachineProductsValidator.checkMachineProducts(inputProductLine));
		return inputProductLine;
	}

	private String orderProductNameUntilValid() {
		String productName;
		do {
			productName = Console.readLine();
		} while (!OrderValidator.checkProductName(productName));
		return productName;
	}
}
