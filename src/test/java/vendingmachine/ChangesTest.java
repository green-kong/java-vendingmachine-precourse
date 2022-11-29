package vendingmachine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vendingmachine.domain.Changes;

import java.util.EnumMap;

public class ChangesTest {
    Changes changes;

    @BeforeEach
    void createChanges() {
        EnumMap<Coin, Integer> changeMap = new EnumMap<Coin, Integer>(Coin.class);
        changes = new Changes(changeMap);
    }

    @Test
    @DisplayName("랜덤 동전 생성 확인")
    void checkRandomCoin() {
        int input = 4500;
        changes.createRandomCoin(input);
    }
}
