package vendingmachine.validator;

public class MoneyValidator extends PositiveNumberValidator{
	private static final String ERROR_NOT_MULTI_TEN = "10의 배수가 아닙니다.";
	private static final int MULTI_VALUE = 10;

	@Override
	public void exceptionInvalid(String line) {
		exceptionNotNumber(line);
		exceptionNotPositiveNumber(line);
		exceptionZero(line);
		exceptionNotMultiTen(line);
	}

	private static void exceptionNotMultiTen(String line) {
		if (Long.parseLong(line) % MULTI_VALUE != 0) {
			throw new IllegalArgumentException(ERROR_NOT_MULTI_TEN);
		}
	}
}
