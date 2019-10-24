package com.gating.operators.impl;

import com.gating.operators.AbstractOperator;
import com.gating.enums.OperatorInfo;
import com.gating.operators.handler.BinaryOperatorTypeHandler;
import lombok.RequiredArgsConstructor;

import java.util.List;

public class NotEqualsTo extends AbstractOperator {

    // This must be equals handler we will negate result for not equals to
    private final BinaryOperatorTypeHandler handler;

    public NotEqualsTo(BinaryOperatorTypeHandler handler) {
        super(OperatorInfo.NotEqualsTo);
        this.handler = handler;
    }

    public <T> Boolean apply(List<T> operands) throws Exception {
        validateOperands(operands);
        return !this.handler.apply(operands.get(0), (String) operands.get(1));
    }
}
