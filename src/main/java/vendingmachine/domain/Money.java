package vendingmachine.domain;

import vendingmachine.domain.product.Price;

public class Money {
	private static final String ERROR_NOT_NUMBER = "입력값이 숫자가 아닙니다.";
	private static final String ERROR_NOT_POSITIVE_NUMBER = "입력값이 양수가 아닙니다.";
	private static final String ERROR_NOT_MULTI_TEN = "10의 배수가 아닙니다.";
	private static final String ERROR_MONEY_ZERO = "금액은 0이 될 수 없습니다.";
	private static final int FIRST_DIGIT_INDEX = 0;
	private static final int MULTI_VALUE = 10;
	private static final char MINUS = '-';

	private long money;

	private Money(String line) {
		money = Long.parseLong(line);
	}

	public static Money of(String line) {
		return new Money(line);
	}

	public static void exceptionInvalidInputMoney(String line) {
		exceptionNotNumber(line);
		exceptionNotPositiveNumber(line);
		exceptionNotMultiTen(line);
		exceptionZero(line);
	}

	private static void exceptionNotNumber(String line) {
		try {
			Long.parseLong(line);
		} catch (NumberFormatException exception) {
			throw new IllegalArgumentException(ERROR_NOT_NUMBER);
		}
	}

	private static void exceptionNotPositiveNumber(String line) {
		if (line.charAt(FIRST_DIGIT_INDEX) == MINUS) {
			throw new IllegalArgumentException(ERROR_NOT_POSITIVE_NUMBER);
		}
	}

	private static void exceptionNotMultiTen(String line) {
		if (Long.parseLong(line) % MULTI_VALUE != 0) {
			throw new IllegalArgumentException(ERROR_NOT_MULTI_TEN);
		}
	}

	private static void exceptionZero(String string) {
		if (Integer.parseInt(string) == 0) {
			throw new IllegalArgumentException(ERROR_MONEY_ZERO);
		}
	}
	public long getMoney() {
		return money;
	}

	@Override
	public String toString() {
		return money + "원";
	}

	public void subtractOf(Price price) {
		money = price.subtractFrom(money);
	}
	public boolean isNotSmallerThan(Price price) {
		if (price.subtractFrom(money) >=0) {
			return true;
		}
		return false;
	}
}
