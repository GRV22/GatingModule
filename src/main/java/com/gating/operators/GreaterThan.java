package com.gating.operators;

import java.util.List;

public class GreaterThan extends AbstractOperator {

    public GreaterThan() {
        super(OperatorInfo.GreaterThan);
    }

    public <T> Boolean operate(List<T> operands) throws Exception {
        validateOperands(operands);
        for (T operand : operands) {
            if (!(operand instanceof Integer)) {
                throw new Exception("For GreaterThan Operation operands should be Integer type");
            }
        }
        Integer operand1 = (Integer) operands.get(0);
        Integer operand2 = (Integer) operands.get(1);
        return operand1 > operand2;
    }
}
