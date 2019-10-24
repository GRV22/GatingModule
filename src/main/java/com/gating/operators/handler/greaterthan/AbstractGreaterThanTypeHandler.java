package com.gating.operators.handler.greaterthan;

import com.gating.operators.handler.BinaryOperatorTypeHandler;

public abstract class AbstractGreaterThanTypeHandler<T> implements BinaryOperatorTypeHandler {

    protected void markImpression() {
        System.out.println("Visiting : " + this.getClass());
    }

    public void validateNotNull(BinaryOperatorTypeHandler next) {
        if (null == next) {
            throw new UnsupportedOperationException();
        }
    }

}
