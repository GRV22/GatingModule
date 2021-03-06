package com.gating.operators.handler.lessthan;

import com.gating.operators.handler.BinaryOperatorTypeHandler;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LessThanIntegerHandler extends AbstractLessThanTypeHandler<Integer> {

    private final BinaryOperatorTypeHandler next;

    @Override
    public boolean apply(final Object val, final String val1) {
        if (val instanceof Integer) {
            return (Integer) val < Integer.parseInt(val1);
        } else {
            validateNotNull(next);
            return this.next.apply(val, val1);
        }
    }
}
