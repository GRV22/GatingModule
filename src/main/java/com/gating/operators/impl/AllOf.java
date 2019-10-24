package com.gating.operators.impl;

import com.gating.enums.OperatorInfo;
import com.gating.operators.AbstractOperator;
import com.gating.operators.handler.BinaryOperatorTypeHandler;

import java.util.List;

public class AllOf extends AbstractOperator {

    private final BinaryOperatorTypeHandler handler;

    public AllOf(BinaryOperatorTypeHandler handler) {
        super(OperatorInfo.AllOf);
        this.handler = handler;
    }

    public <T> Boolean apply(List<T> operands) throws Exception {
        validateOperands(operands);
        return handler.apply(operands.get(0), (String) operands.get(1));
    }
}
