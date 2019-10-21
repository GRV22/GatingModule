package com.gating.operators.impl;

import com.gating.operators.AbstractOperator;
import com.gating.enums.OperatorInfo;

import java.util.List;

public class Between extends AbstractOperator {

    public Between() {
        super(OperatorInfo.Between);
    }

    public <T> Boolean apply(List<T> operands) throws Exception {
        validateOperands(operands);
        for (T operand : operands) {
            if (!(operand instanceof Integer)) {
                throw new Exception("For Between Operation operands should be Integer type");
            }
        }
        Integer operand1 = (Integer) operands.get(0);
        Integer operand2 = (Integer) operands.get(1);
        Integer operand3 = (Integer) operands.get(2);
        return (operand1 >= operand2) && (operand1 <= operand3);
    }
}
