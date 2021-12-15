package vendingmachine.domain.product;

public class Count {
	private static final String ERROR_COUNT_ZERO = "갯수가 0이면 안됩니다.";
	private int count;

	private Count(int count) {
		this.count = count;
	}

	public static Count of(String string) {
		exceptionZero(string);
		return new Count(Integer.parseInt(string));
	}

	private static void exceptionZero(String string) {
		if (Integer.parseInt(string) == 0) {
			throw new IllegalArgumentException(ERROR_COUNT_ZERO);
		}
	}

	public void subtract() {
		count--;
	}

	public boolean remainZero() {
		return count == 0;
	}
}
