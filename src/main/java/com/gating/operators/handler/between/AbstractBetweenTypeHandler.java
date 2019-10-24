package com.gating.operators.handler.between;

import com.gating.operators.handler.TernaryOperatorTypeHandler;

public abstract class AbstractBetweenTypeHandler<T> implements TernaryOperatorTypeHandler {

    public void validateNotNull(final TernaryOperatorTypeHandler next) {
        if (null == next) {
            throw new UnsupportedOperationException();
        }
    }

}
