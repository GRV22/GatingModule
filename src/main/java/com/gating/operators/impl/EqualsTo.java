package com.gating.operators.impl;

import com.gating.operators.AbstractOperator;
import com.gating.enums.OperatorInfo;
import com.gating.operators.handler.BinaryOperatorTypeHandler;

import java.util.List;

public class EqualsTo extends AbstractOperator {

    private final BinaryOperatorTypeHandler handler;

    public EqualsTo(final BinaryOperatorTypeHandler handler) {
        super(OperatorInfo.EqualsTo);
        this.handler = handler;
    }

    public <T> Boolean apply(final List<T> operands) throws Exception {
        validateOperands(operands);
        return handler.apply(operands.get(0), (String) operands.get(1));
    }
}
