package com.gating.operators.handler.lessthan;

import com.gating.operators.handler.BinaryOperatorTypeHandler;

public abstract class AbstractLessThanTypeHandler<T> implements BinaryOperatorTypeHandler {

    public void validateNotNull(final BinaryOperatorTypeHandler next) {
        if (null == next) {
            throw new UnsupportedOperationException();
        }
    }

}
