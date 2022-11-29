package vendingmachine.domain;

import vendingmachine.Coin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

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

    public List<String> getHoldingCoin() {
        List<String> holdingCoinResult = new ArrayList<>();
        String resultLayout = "%s - %d개";
        Arrays.stream(Coin.values())
                .forEach(coin -> holdingCoinResult.add(String.format(resultLayout, coin.getAmountName(), changeMap.get(coin))));
        return holdingCoinResult;
    }
}
