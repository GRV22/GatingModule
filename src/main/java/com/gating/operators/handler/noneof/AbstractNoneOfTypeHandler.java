package com.gating.operators.handler.noneof;

import com.gating.operators.handler.BinaryOperatorTypeHandler;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;

public abstract class AbstractNoneOfTypeHandler<T> implements BinaryOperatorTypeHandler {

    protected boolean isNullOrEmpty(Object val) {
        return (null == val || (val instanceof Collection && CollectionUtils.isEmpty((Collection<?>) val)));
    }

    public void validateNotNull(BinaryOperatorTypeHandler next) {
        if (null == next) {
            throw new UnsupportedOperationException();
        }
    }

}
