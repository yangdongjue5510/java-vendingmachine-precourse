package vendingmachine.domain;

import static vendingmachine.Constants.*;

public class Nameable {
	protected static String validationName(String name) {
		exceptionEmptyName(name);
		return name;
	}

	protected static void exceptionEmptyName(String name) {
		if (name.equals(EMPTY_STRING)) {
			throw new IllegalArgumentException();
		}
	}
}
