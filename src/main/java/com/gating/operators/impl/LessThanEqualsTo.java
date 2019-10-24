package com.gating.operators.impl;

import com.gating.operators.AbstractOperator;
import com.gating.enums.OperatorInfo;
import com.gating.operators.handler.BinaryOperatorTypeHandler;

import java.util.List;

public class LessThanEqualsTo extends AbstractOperator {

    private final BinaryOperatorTypeHandler handler;

    public LessThanEqualsTo(final BinaryOperatorTypeHandler handler) {
        super(OperatorInfo.LessThanEqualsTo);
        this.handler = handler;
    }

    public <T> Boolean apply(final List<T> operands) throws Exception {
        validateOperands(operands);
        return !handler.apply(operands.get(0), (String) operands.get(1));
    }
}
