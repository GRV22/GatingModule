package com.gating.operators.handler.equalsto;

import com.gating.operators.handler.BinaryOperatorTypeHandler;

public abstract class AbstractEqualsToTypeHandler<T> implements BinaryOperatorTypeHandler {

    protected void markImpression() {
        System.out.println("Visiting : " + this.getClass());
    }

    public void validateNotNull(BinaryOperatorTypeHandler next) {
        if (null == next) {
            throw new UnsupportedOperationException();
        }
    }

}
