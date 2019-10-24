package com.gating.operators.handler.between;

import com.gating.operators.handler.TernaryOperatorTypeHandler;

public abstract class AbstractBetweenTypeHandler<T> implements TernaryOperatorTypeHandler {

    protected void markImpression() {
        System.out.println("Visiting : " + this.getClass());
    }

    public void validateNotNull(TernaryOperatorTypeHandler next) {
        if (null == next) {
            throw new UnsupportedOperationException();
        }
    }

}
