package com.gating.operators.impl;

import com.gating.enums.OperatorInfo;
import com.gating.operators.AbstractOperator;
import com.gating.operators.handler.TernaryOperatorTypeHandler;

import java.util.List;

public class Between extends AbstractOperator {

    private final TernaryOperatorTypeHandler handler;

    public Between(TernaryOperatorTypeHandler handler) {
        super(OperatorInfo.Between);
        this.handler = handler;
    }

    public <T> Boolean apply(List<T> operands) throws Exception {
        validateOperands(operands);
        return handler.apply(operands.get(0), (String) operands.get(1), (String) operands.get(2));
    }
}
