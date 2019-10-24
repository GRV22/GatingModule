package com.gating.operators.impl;

import com.gating.operators.AbstractOperator;
import com.gating.enums.OperatorInfo;
import com.gating.operators.handler.BinaryOperatorTypeHandler;

import java.util.List;

public class GreaterThanEqualsTo extends AbstractOperator {

    private final BinaryOperatorTypeHandler handler;

    public GreaterThanEqualsTo(final BinaryOperatorTypeHandler handler) {
        super(OperatorInfo.GreaterThanEqualsTo);
        this.handler = handler;
    }

    public <T> Boolean apply(final List<T> operands) throws Exception {
        validateOperands(operands);
        return !handler.apply(operands.get(0), (String) operands.get(1));
    }
}
