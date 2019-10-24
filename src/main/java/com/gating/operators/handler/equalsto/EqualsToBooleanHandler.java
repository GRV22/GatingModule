package com.gating.operators.handler.equalsto;

import com.gating.operators.handler.BinaryOperatorTypeHandler;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EqualsToBooleanHandler extends AbstractEqualsToTypeHandler<Boolean> {

    private final BinaryOperatorTypeHandler next;

    @Override
    public boolean apply(Object val, String val1) {
        if (val instanceof Boolean) {
            return ((Boolean) val) == Boolean.parseBoolean(val1);
        } else {
            validateNotNull(next);
            return this.next.apply(val, val1);
        }
    }
}
