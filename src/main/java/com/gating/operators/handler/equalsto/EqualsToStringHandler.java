package com.gating.operators.handler.equalsto;

import com.gating.operators.handler.BinaryOperatorTypeHandler;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EqualsToStringHandler extends AbstractEqualsToTypeHandler<String> {

    private final BinaryOperatorTypeHandler next;

    @Override
    public boolean apply(final Object val, final String val1) {
        if (val instanceof String) {
            return val.equals(val1);
        } else {
            validateNotNull(next);
            return this.next.apply(val, val1);
        }
    }
}
