package com.gating.operators.impl;

import com.gating.operators.AbstractOperator;
import com.gating.enums.OperatorInfo;

import java.util.List;

public class EqualsTo extends AbstractOperator {

    public EqualsTo() {
        super(OperatorInfo.EqualsTo);
    }

    public <T> Boolean apply(List<T> operands) throws Exception {
        validateOperands(operands);
        T operand1 = operands.get(0);
        T operand2 = operands.get(1);
        if (operand1 instanceof String && operand2 instanceof String) {
            return ((String) operand1).equalsIgnoreCase((String) operand2);
        }
        return operand1.equals(operand2);
    }
}
