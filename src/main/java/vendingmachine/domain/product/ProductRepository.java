package vendingmachine.domain.product;

import static vendingmachine.Constants.*;

import vendingmachine.domain.MoneyRepository;
import vendingmachine.domain.Order;

public class ProductRepository {
	private static ProductsInformation productInformation;

	public static void setProductInformation() {
		productInformation = new ProductsInformation();
	}

	public static Product findProductsByName(String name) {
		Product foundProduct = productInformation.getProductList().stream()
			.filter(product -> product.getName().equals(name))
			.findAny().orElse(null);
		return foundProduct;
	}

	public static boolean checkPayable() {
		long userMoney = MoneyRepository.getUserMoney();
		if (!isAllProductCountZero() && userMoney >= findLowestPrice()) {
			return true;
		}
		return false;
	}

	public static void consumeProduct(Order order) {
		Product orderProduct = order.getOrderProduct();
		productInformation.getProductList().stream()
			.filter(product -> product.equals(orderProduct))
			.forEach(product -> product.consumeProduct());
	}

	private static long findLowestPrice() {
		return productInformation.getProductList().stream()
			.filter(product -> product.isNotEmpty())
			.mapToLong(product -> product.getPrice())
			.min().getAsLong();
	}

	private static boolean isAllProductCountZero() {
		return productInformation.getProductList().stream()
			.filter(product -> product.isNotEmpty())
			.count() == ZERO;
	}
}
