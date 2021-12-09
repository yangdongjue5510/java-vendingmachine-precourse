package vendingmachine.view;

public class ConstantMessage {
	public static final String MESSAGE_INPUT_MONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	public static final String MESSAGE_COIN = "\n자판기가 보유한 동전";
	public static final String MESSAGE_INPUT_PRODUCT = "\n상품명과 가격, 수량을 입력해 주세요.";
	public static final String ERROR = "[ERROR]";
	public static final String ERROR_INPUT_MONEY_NOT_NUMBER = ERROR + " 금액은 숫자로 이뤄져야 합니다.";
	public static final String ERROR_INPUT_MONEY_EMPTY = ERROR + " 빈 금액은 입력할 수 없습니다.";
	public static final String ERROR_INPUT_MONEY_ZERO = ERROR + " 0원은 입력할 수 없습니다.";
}
