package vendingmachine.domain.product;

public class Count extends PositiveNumber{
	public Count(String inputLine) {
		super(inputLine);
	}

	public void consumeCount() {
		this.number -= 1;
	}
}
