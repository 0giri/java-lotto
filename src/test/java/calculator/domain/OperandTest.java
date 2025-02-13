package calculator.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class OperandTest {

    @Test
    void null_입력시_IllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Operand(null));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "a", "-"})
    void 숫자_형식_아니면_NumberFormatException(String value) {
        assertThatThrownBy(() -> new Operand(new Number(value))).isInstanceOf(NumberFormatException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "1234"})
    void 숫자_형식_성공(String value) {
        assertThatNoException().isThrownBy(() -> new Operand(new Number(value)));
    }
}
