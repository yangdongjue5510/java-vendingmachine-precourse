package vendingmachine.domain.product;

public class ProductName {
	private String productName;

	private ProductName(String productName) {
		this.productName = productName;
	}

	public static ProductName of(String string) {
		return new ProductName(string);
	}
}
