package vendingmachine.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductValidator implements Validator {
	private static final String ERROR_INVALID_FORMAT = "잘못된 상품 형식입니다.";
	private static Pattern pattern = Pattern.compile("^\\[[가-힣a-zA-Z0-9]+,[0-9]{3,},[0-9]+\\]$");

	@Override
	public void exceptionInvalid(String productsLine) {
		Matcher matcher = pattern.matcher(productsLine);
		if (!matcher.matches()) {
			throw new IllegalArgumentException(ERROR_INVALID_FORMAT);
		}
	}
}
