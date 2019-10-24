package com.gating.operators.handler.allof;

import com.gating.operators.handler.BinaryOperatorTypeHandler;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;

public abstract class AbstractAllOfTypeHandler<T> implements BinaryOperatorTypeHandler {

    protected boolean isNullOrEmpty(final Object val) {
        return (null == val || (val instanceof Collection && CollectionUtils.isEmpty((Collection<?>) val)));
    }

    public void validateNotNull(final BinaryOperatorTypeHandler next) {
        if (null == next) {
            throw new UnsupportedOperationException();
        }
    }

}
