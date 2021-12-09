package vendingmachine.domain;

public class ProductRepository {
	private static ProductsInformation productInformation;

	public static void setProductInformation() {
		productInformation = new ProductsInformation();
	}
}
