package com.gating.operators.handler.lessthan;

import com.gating.operators.handler.BinaryOperatorTypeHandler;

public abstract class AbstractLessThanTypeHandler<T> implements BinaryOperatorTypeHandler {

    protected void markImpression() {
        System.out.println("Visiting : " + this.getClass());
    }

    public void validateNotNull(BinaryOperatorTypeHandler next) {
        if (null == next) {
            throw new UnsupportedOperationException();
        }
    }

}
