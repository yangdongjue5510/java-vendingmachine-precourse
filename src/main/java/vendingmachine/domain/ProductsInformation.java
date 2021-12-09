package vendingmachine.domain;

import static vendingmachine.Constants.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.view.ErrorView;

public class ProductsInformation {
	private List<Product> productList = new ArrayList<>();

	public ProductsInformation() {
		List<String> informations;
		do {
			informations = Arrays.asList(Console.readLine().split(SEMICOLON));
			setProductList(informations);
		} while (!validateProductsInformation(informations));
	}

	private boolean validateProductsInformation(List<String> products) {
		try {
			executeAllExceptionCheck(products);
			return true;
		} catch (IllegalArgumentException exception) {
			ErrorView.invalidProductInput();
			return false;
		}
	}

	private void executeAllExceptionCheck(List<String> products) {
		for (String productString : products) {
			exceptionProductWithBrackets(productString);
		}
	}

	private void exceptionProductWithBrackets(String productString) {
		char startChar = productString.charAt(0);
		char endChar = productString.charAt(productString.length() - 1);
		if (startChar != LEFT_BRACKET || endChar != RIGHT_BRACKET) {
			throw new IllegalArgumentException();
		}
	}

	private void setProductList(List<String> productsInformation) {
		for (String productString : productsInformation) {
			productList.add(makeProduct(splitInformationComma(productString)));
		}
	}

	private List<String> splitInformationComma(String productString) {
		return Arrays.asList(productString.substring(1, productString.length() - 1).split(COMMA));
	}

	private Product makeProduct(List<String> productInformation) {
		return new Product(productInformation);
	}

}
