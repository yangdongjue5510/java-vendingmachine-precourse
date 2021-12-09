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
			informations = inputInformations();
		} while (!productListSuccess(informations));
	}

	private boolean productListSuccess(List<String> informations) {
		try {
			setProductList(informations);
			return true;
		} catch (IllegalArgumentException exception) {
			ErrorView.invalidProductInput();
			return false;
		}
	}

	private List<String> inputInformations() {
		List<String> informations;
		do {
			informations = Arrays.asList(Console.readLine().split(SEMICOLON));
		} while (!validateProductsInformation(informations));
		return informations;
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
			exceptionEmpty(productString);
			exceptionProductWithBrackets(productString);
		}
	}

	private void exceptionEmpty(String productString) {
		if (productString.equals(EMPTY_STRING)) {
			throw new IllegalArgumentException();
		}
	}

	private void exceptionProductWithBrackets(String productString) {
		char startChar = productString.charAt(0);
		char endChar = productString.charAt(productString.length() - 1);
		if (startChar != LEFT_BRACKET || endChar != RIGHT_BRACKET) {
			throw new IllegalArgumentException();
		}
	}

	private void setProductList(List<String> productsInformation) throws IllegalArgumentException {
		for (String productString : productsInformation) {
			productList.add(getProduct(productString));
		}
	}

	private Product getProduct(String productInformation) throws IllegalArgumentException {
		return Product.makeProduct(productInformation);
	}
}
