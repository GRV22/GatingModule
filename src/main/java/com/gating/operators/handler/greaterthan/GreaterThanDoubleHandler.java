package com.gating.operators.handler.greaterthan;

import com.gating.operators.handler.BinaryOperatorTypeHandler;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GreaterThanDoubleHandler extends AbstractGreaterThanTypeHandler<Double> {

    private final BinaryOperatorTypeHandler next;

    @Override
    public boolean apply(Object val, String val1) {
        markImpression();
        if (val instanceof Double) {
            return (Double) val > Double.parseDouble(val1);
        } else {
            validateNotNull(next);
            return this.next.apply(val, val1);
        }
    }
}
