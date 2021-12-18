package vendingmachine.validator;

public class PositiveNumberValidator implements Validator{
	private static final String ERROR_NOT_NUMBER = "입력값이 숫자가 아닙니다.";
	private static final String ERROR_NOT_POSITIVE_NUMBER = "입력값이 양수가 아닙니다.";
	private static final String ERROR_MONEY_ZERO = "금액은 0이 될 수 없습니다.";
	private static final int FIRST_DIGIT_INDEX = 0;
	private static final char MINUS = '-';

	@Override
	public void exceptionInvalid(String line) {
		exceptionNotNumber(line);
		exceptionNotPositiveNumber(line);
		exceptionZero(line);
	}

	protected static void exceptionNotNumber(String line) {
		try {
			Long.parseLong(line);
		} catch (NumberFormatException exception) {
			throw new IllegalArgumentException(ERROR_NOT_NUMBER);
		}
	}

	protected static void exceptionNotPositiveNumber(String line) {
		if (line.charAt(FIRST_DIGIT_INDEX) == MINUS) {
			throw new IllegalArgumentException(ERROR_NOT_POSITIVE_NUMBER);
		}
	}

	protected static void exceptionZero(String string) {
		if (Integer.parseInt(string) == 0) {
			throw new IllegalArgumentException(ERROR_MONEY_ZERO);
		}
	}
}
