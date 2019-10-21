package com.gating.operators;

import java.util.List;

public class NotEqualsTo extends AbstractOperator {

    public NotEqualsTo() {
        super(OperatorInfo.NotEqualsTo);
    }

    public <T> Boolean operate(List<T> operands) throws Exception {
        validateOperands(operands);
        T operand1 = operands.get(0);
        T operand2 = operands.get(1);
        if (operand1 instanceof String && operand2 instanceof String) {
            return !((String) operand1).equalsIgnoreCase((String) operand2);
        }
        return !operand1.equals(operand2);
    }
}
