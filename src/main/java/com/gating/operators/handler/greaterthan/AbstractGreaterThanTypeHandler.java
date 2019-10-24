package com.gating.operators.handler.greaterthan;

import com.gating.operators.handler.BinaryOperatorTypeHandler;

public abstract class AbstractGreaterThanTypeHandler<T> implements BinaryOperatorTypeHandler {

    public void validateNotNull(final BinaryOperatorTypeHandler next) {
        if (null == next) {
            throw new UnsupportedOperationException();
        }
    }

}
