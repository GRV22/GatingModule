package com.gating.operators.handler.equalsto;

import com.gating.operators.handler.BinaryOperatorTypeHandler;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EqualsToIntegerHandler extends AbstractEqualsToTypeHandler<Integer> {

    private final BinaryOperatorTypeHandler next;

    @Override
    public boolean apply(final Object val, final String val1) {
        if (val instanceof Integer) {
            return Integer.compare(((Integer) val), Integer.parseInt(val1)) == 0;
        } else {
            validateNotNull(next);
            return this.next.apply(val, val1);
        }
    }
}
