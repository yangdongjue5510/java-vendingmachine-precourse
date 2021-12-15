package vendingmachine.domain;

public class InputMoney {
	private static final String ERROR_NOT_NUMBER = "입력값이 숫자가 아닙니다.";
	private static final String ERROR_NOT_POSITIVE_NUMBER = "입력값이 양수가 아닙니다.";
	private static final String ERROR_NOT_MULTI_TEN = "10의 배수가 아닙니다.";
	private static final int FIRST_DIGIT_INDEX = 0;
	private static final int MULTI_VALUE = 10;
	private static final char MINUS = '-';

	private long inputMoney;

	private InputMoney(String line) {
		inputMoney = Long.parseLong(line);
	}

	public static InputMoney of(String line) {
		return new InputMoney(line);
	}

	public static void exceptionInvalidInputMoney(String line) {
		exceptionNotNumber(line);
		exceptionNotPositiveNumber(line);
		exceptionNotMultiTen(line);
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
}
