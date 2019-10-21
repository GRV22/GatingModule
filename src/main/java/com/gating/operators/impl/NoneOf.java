package com.gating.operators.impl;

import com.gating.operators.AbstractOperator;
import com.gating.enums.OperatorInfo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NoneOf extends AbstractOperator {

    public NoneOf() {
        super(OperatorInfo.NoneOf);
    }

    public <T> Boolean apply(List<T> operands) throws Exception {
        validateOperands(operands);
        for (T operand : operands) {
            if (!(operand instanceof String)) {
                throw new Exception("For NoneOf Operation operands should be string type");
            }
        }
        List<String> operand1List = Arrays.asList(((String)operands.get(0)).split(","));
        List<String> operand2List = Arrays.asList(((String)operands.get(1)).split(","));
        return Collections.disjoint(operand1List, operand2List);
    }
}
