package vendingmachine.service;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.validator.Validator;
import vendingmachine.view.OutputView;

public class InputService {
	public static String input(Validator validator) {
		String line;
		try {
			line = Console.readLine();
			validator.exceptionInvalid(line);
		} catch (IllegalArgumentException exception) {
			OutputView.errorView(exception.getMessage());
			line = input(validator);
		}
		return line;
	}
}
