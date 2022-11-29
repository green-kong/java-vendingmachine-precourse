package vendingmachine.service;

import vendingmachine.Coin;
import vendingmachine.domain.Changes;
import vendingmachine.utils.Converter;

import java.util.EnumMap;

public class Service {
    Changes changes = new Changes(new EnumMap<>(Coin.class));

    public void createHoldingCoin(String holdingMoneyInput) {
        int holdingMoney = Converter.toIntFromString(holdingMoneyInput);
        changes.createRandomCoin(holdingMoney);
    }
}
