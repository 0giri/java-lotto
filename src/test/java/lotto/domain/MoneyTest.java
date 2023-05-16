package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class MoneyTest {

    @Test
    void 자연수_또는_0으로_생성시_성공() {
        assertThatNoException().isThrownBy(() -> new Money(0));
        assertThatNoException().isThrownBy(() -> new Money(1));
    }

    @Test
    void 음수로_생성시_IllegalArgumentException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Money(-1));
    }

    @ParameterizedTest
    @CsvSource({"0,0", "9999,9", "10000,10", "10001,10"})
    void 구매가능_횟수_조회(int amount, int expect) {
        Money money = new Money(amount);
        int actual = money.buyCount(Lotto.PRICE);
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    void 현재_금액_나누기() {
        Money money = new Money(1000);
        Money other = new Money(20000);
        double ratio = money.divide(other);
        assertThat(ratio).isEqualTo(0.05);
    }

    @Test
    void 현재_금액_곱하기() {
        Money money = new Money(1000);
        Money result = money.multiply(10);
        assertThat(result).isEqualTo(new Money(10000));
    }
}
