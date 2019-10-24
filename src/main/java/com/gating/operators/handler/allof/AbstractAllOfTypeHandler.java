package com.gating.operators.handler.allof;

import com.gating.operators.handler.BinaryOperatorTypeHandler;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;

public abstract class AbstractAllOfTypeHandler<T> implements BinaryOperatorTypeHandler {

    protected void markImpression() {
        System.out.println("Visiting : " + this.getClass());
    }

    protected boolean isNullOrEmpty(Object val) {
        return (null == val || (val instanceof Collection && CollectionUtils.isEmpty((Collection<?>) val)));
    }

    public void validateNotNull(BinaryOperatorTypeHandler next) {
        if (null == next) {
            throw new UnsupportedOperationException();
        }
    }

    protected void showValue(Object val) {
        System.out.println("val = [" + val + "]");
    }

}
