package vendingmachine.domain;

import vendingmachine.Coin;
import vendingmachine.utils.Validator;

import java.util.*;
import java.util.stream.Collectors;

public class Changes {
    EnumMap<Coin, Integer> changeMap;

    public Changes(EnumMap<Coin, Integer> changeMap) {
        Arrays.stream(Coin.values())
                .forEach(coin -> changeMap.put(coin, 0));
        this.changeMap = changeMap;
    }

    public void createRandomCoin(int money) {
        validate(money);
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

    public Integer getTotal() {
        int total = 0;
        List<Integer> sumList = Arrays.stream(Coin.values())
                .map(coin -> coin.getSum(changeMap.get(coin)))
                .collect(Collectors.toList());
        for (Integer sum : sumList) {
            total += sum;
        }

        return total;
    }

    public List<String> getChangeResult(int deposit) {
        List<Coin> existedCoins = getExistedCoin();
        return generateChangeResults(existedCoins,deposit);
    }

    public List<String> getAllCoinResult() {
        List<Coin> existedCoins = getExistedCoin();
        return existedCoins.stream()
                .map(coin -> String.format(("%s - %d개"), coin.getAmountName(), changeMap.get(coin)))
                .collect(Collectors.toList());
    }

    private void validate(int money) {
        Validator.isAcceptableAmount(money);
    }

    private List<Coin> getExistedCoin() {
        return Arrays.stream(Coin.values())
                .filter(coin -> changeMap.get(coin) > 0)
                .collect(Collectors.toList());
    }

    private List<String> generateChangeResults(List<Coin> existedCoins, int deposit) {
        List<String> changeResults = new ArrayList<>();
        for (Coin coin : existedCoins) {
            if (deposit <= 0) {
                return changeResults;
            }
            int changeCount = coin.getChangeCoinCount(deposit, changeMap.get(coin));
            if (changeCount != 0) {
                changeResults.add(String.format(("%s - %d개"), coin.getAmountName(), changeCount));
                deposit -= coin.getSum(changeCount);
            }
        }
        return changeResults;
    }
}
