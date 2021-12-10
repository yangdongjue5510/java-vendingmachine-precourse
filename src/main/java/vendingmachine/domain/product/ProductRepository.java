package vendingmachine.domain.product;

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
}
