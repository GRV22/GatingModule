package com.gating.operators.impl;

import com.gating.operators.AbstractOperator;
import com.gating.enums.OperatorInfo;

import java.util.List;

public class And extends AbstractOperator {

    public And() {
        super(OperatorInfo.And);
    }

    public <T> Boolean apply(final List<T> operands) throws Exception {
        validateOperands(operands);
        for (final T operand : operands) {
            if (!(operand instanceof Boolean)) {
                throw new Exception("For AND Operation operands should be Boolean type");
            }
        }
        for (final T operand : operands) {
            if (!(Boolean) operand) {
                return false;
            }
        }
        return true;
    }
}
