package vendingmachine.service;

import vendingmachine.domain.product.MachineProducts;
import vendingmachine.domain.product.Product;
import vendingmachine.repository.MachineProductsRepository;

public class ProductService {
	private static final String ERROR_LACK_MONEY = "제품을 구입할 돈이 부족합니다.";
	private static final String ERROR_SOLD_OUT = "제품이 모두 팔렸습니다.";
	private MoneyService moneyService = new MoneyService();

	public void enrollProduct(String productsLine) {
		MachineProducts machineProducts = MachineProducts.of(productsLine);
		MachineProductsRepository.getInstance().enrollProducts(machineProducts);
	}

	public void orderProduct(String inputProductName) {
		Product product =  MachineProductsRepository.getInstance().findProductByName(inputProductName);
		exceptionLackMoney(product);
		exceptionZeroCount(product);
		moneyService.subtractFrom(product);
		subtractProductCount(product);
	}

	private void exceptionLackMoney(Product product) {
		if (!product.canBuy(moneyService.getUserRemainMoney())) {
			throw new IllegalArgumentException(ERROR_LACK_MONEY);
		}
	}

	private void exceptionZeroCount(Product product) {
		if (product.soldOut()) {
			throw new IllegalArgumentException(ERROR_SOLD_OUT);
		}
	}

	private void subtractProductCount(Product product) {
		MachineProductsRepository.getInstance().subtractCount(product);
	}

	public boolean isAllProductSoldOut() {
		return MachineProductsRepository.getInstance().allSoldOut();
	}
}
