package vendingmachine.domain.product;

public class Price {
	private static final String ERROR_NOT_MULTI_TEN = "십의 배수를 입력하세요";
	private static final String ERROR_PRICE_ZERO = "가격이 0이되면 안됩니다.";
	private int price;

	private Price(int price) {
		this.price = price;
	}

	public static Price of(String string) {
		exceptionNotMultiTen(string);
		exceptionZero(string);
		return new Price(Integer.parseInt(string));
	}

	private static void exceptionNotMultiTen(String string) {
		if (Integer.parseInt(string) % 10 != 0) {
			throw new IllegalArgumentException(ERROR_NOT_MULTI_TEN);
		}
	}

	private static void exceptionZero(String string) {
		if (Integer.parseInt(string) == 0) {
			throw new IllegalArgumentException(ERROR_PRICE_ZERO);
		}
	}
}
