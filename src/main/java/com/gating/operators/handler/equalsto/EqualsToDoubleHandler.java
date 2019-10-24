package com.gating.operators.handler.equalsto;

import com.gating.operators.handler.BinaryOperatorTypeHandler;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EqualsToDoubleHandler extends AbstractEqualsToTypeHandler<Double> {

    private final BinaryOperatorTypeHandler next;

    @Override
    public boolean apply(final Object val, final String val1) {
        if (val instanceof Double) {
            return Double.compare(((Double) val), Double.parseDouble(val1)) == 0;
        } else {
            validateNotNull(next);
            return this.next.apply(val, val1);
        }
    }
}
