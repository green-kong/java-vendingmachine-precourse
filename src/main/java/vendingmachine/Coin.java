package vendingmachine;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public static int getRandomAmount() {
        List<Integer> amounts =  Arrays.stream(Coin.values())
                .map(coin -> coin.amount)
                .collect(Collectors.toList());

        return Randoms.pickNumberInList(amounts);
    }
}
