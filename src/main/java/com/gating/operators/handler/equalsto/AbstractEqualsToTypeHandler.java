package com.gating.operators.handler.equalsto;

import com.gating.operators.handler.BinaryOperatorTypeHandler;

public abstract class AbstractEqualsToTypeHandler<T> implements BinaryOperatorTypeHandler {

    public void validateNotNull(final BinaryOperatorTypeHandler next) {
        if (null == next) {
            throw new UnsupportedOperationException();
        }
    }

}
