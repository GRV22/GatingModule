package com.gating.operators.handler.between;

import com.gating.operators.handler.TernaryOperatorTypeHandler;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BetweenDoubleHandler extends AbstractBetweenTypeHandler<Double> {

    private final TernaryOperatorTypeHandler next;

    public boolean apply(final Object val, final String first, final String last) {
        if (val instanceof Double) {
            return Double.compare((Double) val, Double.valueOf(first)) >= 0 && Double.compare((Double) val,
                    Double.valueOf(last)) <= 0;
        } else {
            validateNotNull(next);
            return this.next.apply(val, first, last);
        }
    }
}
