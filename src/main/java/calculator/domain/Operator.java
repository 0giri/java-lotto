package calculator.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator implements ExpressionElement {
    PLUS("+", (preValue, postValue) -> preValue + postValue),
    MINUS("-", (preValue, postValue) -> preValue - postValue),
    MULTIPLY("*", (preValue, postValue) -> preValue * postValue),
    DIVIDE("/", (preValue, postValue) -> preValue / postValue);

    private final String symbol;
    private final BiFunction<Integer, Integer, Integer> expression;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    static Operator find(String symbol) {
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 문자와 일치하는 연산자를 찾을 수 없습니다."));
    }

    Number calculate(Operand preOperand, Operand postOperand) {
        int preValue = preOperand.value();
        int postValue = postOperand.value();
        Integer result = expression.apply(preValue, postValue);
        return new Number(result);
    }
}
