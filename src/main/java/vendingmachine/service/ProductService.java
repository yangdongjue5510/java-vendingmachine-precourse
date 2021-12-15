package vendingmachine.service;

import vendingmachine.domain.product.MachineProducts;
import vendingmachine.repository.MachineProductsRepository;

public class ProductService {
	public void enrollProduct(String productsLine) {
		MachineProducts machineProducts = MachineProducts.of(productsLine);
		MachineProductsRepository.getInstance().enrollProducts(machineProducts);
	}
}
