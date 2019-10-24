package com.gating.operators.handler.between;

import com.gating.operators.handler.TernaryOperatorTypeHandler;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BetweenIntegerHandler extends AbstractBetweenTypeHandler<Integer> {

    private final TernaryOperatorTypeHandler next;

    public boolean apply(Object val, String first, String last) {
        if (val instanceof Integer) {
            return ((Integer) val >= Integer.valueOf(first)) && ((Integer) val <= Integer.valueOf(last));
        } else {
            validateNotNull(next);
            return this.next.apply(val, first, last);
        }
    }
}
