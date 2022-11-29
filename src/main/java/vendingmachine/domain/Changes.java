package vendingmachine.domain;

import vendingmachine.Coin;

import java.util.Arrays;
import java.util.EnumMap;

public class Changes {
    EnumMap<Coin,Integer> changeMap;

    public Changes(EnumMap<Coin,Integer> changeMap) {
        Arrays.stream(Coin.values())
                .forEach(coin -> changeMap.put(coin, 0 ));
        this.changeMap = changeMap;
    }
}
