package vendingmachine.domain.coin;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;
    private static final String WON = "원";

    Coin(final int amount) {
        this.amount = amount;
    }

    public boolean isNotBiggerThan(long moneyAmount) {
        return moneyAmount >= amount;
    }

    public long subtractFrom(long moneyAmount) {
        return moneyAmount - amount;
    }

    public static List<Integer> coinAmountValues() {
        return Arrays.asList(Coin.values())
            .stream()
            .map(coin -> coin.amount)
            .collect(Collectors.toList());
    }

    public static Coin coinOf(long amount) {
        return Arrays.asList(Coin.values())
            .stream()
            .filter(coin-> coin.amount == amount)
            .findFirst().get();
    }

    @Override
    public String toString() {
        return amount + WON;
    }
}
