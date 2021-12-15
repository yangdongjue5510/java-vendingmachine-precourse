package vendingmachine.repository;

import vendingmachine.domain.product.MachineProducts;

public class MachineProductsRepository {
	private static final MachineProductsRepository repository = new MachineProductsRepository();
	private MachineProducts machineProducts;

	public static MachineProductsRepository getInstance() {
		return repository;
	}

	public void enrollProducts(MachineProducts products) {
		machineProducts = products;
	}
}
