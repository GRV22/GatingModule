package com.gating.operators.handler.greaterthan;

import com.gating.operators.handler.BinaryOperatorTypeHandler;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GreaterThanIntegerHandler extends AbstractGreaterThanTypeHandler<Integer> {

    private final BinaryOperatorTypeHandler next;

    @Override
    public boolean apply(Object val, String val1) {
        markImpression();
        if (val instanceof Integer) {
            return (Integer) val > Integer.parseInt(val1);
        } else {
            validateNotNull(next);
            return this.next.apply(val, val1);
        }
    }
}
