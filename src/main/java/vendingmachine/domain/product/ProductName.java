package vendingmachine.domain.product;

import java.util.Objects;

public class ProductName {
	private String productName;

	private ProductName(String productName) {
		this.productName = productName;
	}

	public static ProductName of(String string) {
		return new ProductName(string);
	}

	@Override
	public boolean equals(Object object) {
		if (productName.equals(String.valueOf(object))) {
			return true;
		}
		if (object.getClass() == this.getClass()) {
			return productName.equals(((ProductName)object).productName);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(productName);
	}
}
