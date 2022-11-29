package vendingmachine;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
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

    @DisplayName("입력받은 금액이 10원단위로 나눠떨어지지 않을경우 예외처리")
    @ParameterizedTest(name = "{displayName} input = {0}")
    @ValueSource(ints = {1, 11, 21})
    void checkMoneyUnit(int input) {
        assertThatThrownBy(() -> changes.createRandomCoin(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
