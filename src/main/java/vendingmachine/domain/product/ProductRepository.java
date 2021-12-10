package vendingmachine.domain.product;

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
		if (!isAnyProductCountZero() && userMoney >= findLowestPrice()) {
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
			.mapToLong(product -> product.getPrice().getNumber())
			.min().getAsLong();
	}

	private static boolean isAnyProductCountZero() {
		return productInformation.getProductList().stream()
			.mapToLong(product -> product.getCount().getNumber())
			.min().getAsLong() == 0L;
	}
}
