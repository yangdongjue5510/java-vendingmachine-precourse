package vendingmachine.domain.product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MachineProducts {
	List<Product> productList;

	private MachineProducts() {
		productList = new ArrayList<>();
	}

	public static MachineProducts of(String productsLine) {
		MachineProducts machineProducts = new MachineProducts();
		Arrays.asList(productsLine.split(";")).stream()
			.map(productLine -> Product.of(productLine))
			.forEach(product -> machineProducts.addToMachine(product));
		return machineProducts;
	}

	private void addToMachine(Product product) {
		productList.add(product);
	}
}
