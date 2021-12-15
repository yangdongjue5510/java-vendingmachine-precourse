package vendingmachine.repository;

import vendingmachine.domain.product.MachineProducts;
import vendingmachine.domain.product.Product;

public class MachineProductsRepository {
	private static final MachineProductsRepository repository = new MachineProductsRepository();
	private MachineProducts machineProducts;

	public static MachineProductsRepository getInstance() {
		return repository;
	}

	public void enrollProducts(MachineProducts products) {
		machineProducts = products;
	}

	public Product findProductByName(String inputProductName) {
		return machineProducts.findByName(inputProductName);
	}

	public void subtractCount(Product product) {
		machineProducts.subtractProduct(product);
	}

	public boolean allSoldOut() {
		return machineProducts.allMatchSoldOut();
	}

	public Product findCheapestNotSoldOut() {
		return machineProducts.firstMatchCheapestNotSoldOut();
	}
}
