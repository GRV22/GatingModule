package com.gating.operators.impl;

import com.gating.operators.AbstractOperator;
import com.gating.enums.OperatorInfo;

import java.util.List;

public class And extends AbstractOperator {

    public And() {
        super(OperatorInfo.And);
    }

    public <T> Boolean apply(List<T> operands) throws Exception {
        validateOperands(operands);
        for (T operand : operands) {
            if (!(operand instanceof Boolean)) {
                throw new Exception("For AND Operation operands should be Boolean type");
            }
        }
        for (T operand : operands) {
            if (!(Boolean) operand) {
                return false;
            }
        }
        return true;
    }
}
