package vendingmachine.domain.product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MachineProducts {
	private static final String ERROR_NO_NAME = "동일한 이름의 제품을 찾을 수 없습니다.";
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

	public Product findByName(String inputProductName) {
		exceptionNoName(inputProductName);
		return productList.stream().filter(product -> product.nameIs(inputProductName)).findFirst().get();
	}

	public void exceptionNoName(String productName) {
		if (!isContainName(productName)) {
			throw new IllegalArgumentException(ERROR_NO_NAME);
		}
	}

	private boolean isContainName(String inputProductName) {
		return productList.stream().filter(product -> product.nameIs(inputProductName)).findFirst().isPresent();
	}

	public void subtractProduct(Product product) {
		int index = productList.indexOf(product);
		productList.set(index, product.consume());
	}

	public boolean allMatchSoldOut() {
		return productList.stream().allMatch(product -> product.soldOut());
	}

	public Product firstMatchCheapestNotSoldOut() {
		Collections.sort(productList);
		return productList.stream()
			.filter(product -> !product.soldOut())
			.findFirst().get();
	}
}
