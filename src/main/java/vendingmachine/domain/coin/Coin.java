package vendingmachine.domain.coin;

import java.util.Arrays;
import java.util.List;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isSameAmount(long amount) {
        return getAmount() == amount;
    }

    public static Coin findCoinByAmount(int amount) {
        List<Coin> coins = Arrays.asList(Coin.values());
        return coins.stream().filter(coin -> coin.isSameAmount(amount)).findFirst().get();
    }
}
