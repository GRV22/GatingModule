package com.gating.operators.handler.lessthan;

import com.gating.operators.handler.BinaryOperatorTypeHandler;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LessThanStringHandler extends AbstractLessThanTypeHandler<String> {

    private final BinaryOperatorTypeHandler next;

    @Override
    public boolean apply(final Object val, final String val1) {
        if (val instanceof String) {
            return ((String) val).compareTo(val1) < 0;
        } else {
            validateNotNull(next);
            return this.next.apply(val, val1);
        }
    }
}
