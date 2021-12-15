package vendingmachine.view;

public class OutputView {
	private static String ERROR = "[ERROR] ";
	public static void errorView(String errorMessage) {
		System.out.println(ERROR + errorMessage);
	}
}
