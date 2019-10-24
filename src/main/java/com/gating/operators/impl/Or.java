package com.gating.operators.impl;

import com.gating.enums.OperatorInfo;
import com.gating.operators.AbstractOperator;

import java.util.List;

public class Or extends AbstractOperator {

    public Or() {
        super(OperatorInfo.Or);
    }

    public <T> Boolean apply(final List<T> operands) throws Exception {
        validateOperands(operands);
        for (final T operand : operands) {
            if (!(operand instanceof Boolean)) {
                throw new Exception("For OR Operation operands should be Boolean type");
            }
        }
        for (final T operand : operands) {
            if ((Boolean) operand) {
                return true;
            }
        }
        return false;
    }
}
