package vendingmachine.domain;

import vendingmachine.Coin;

import java.util.Arrays;
import java.util.EnumMap;

public class Changes {
    EnumMap<Coin, Integer> changeMap;

    public Changes(EnumMap<Coin, Integer> changeMap) {
        Arrays.stream(Coin.values())
                .forEach(coin -> changeMap.put(coin, 0));
        this.changeMap = changeMap;
    }

    public void createRandomCoin(int money) {
        while (money > 0) {
            int randomAmount = Coin.getRandomAmount();
            if (money - randomAmount >= 0) {
                money -= randomAmount;
                Coin coin = Coin.getCoinByAmount(randomAmount);
                changeMap.put(coin, changeMap.get(coin) + 1);
            }
        }
    }
}
