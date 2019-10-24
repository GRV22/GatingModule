package com.gating.operators.handler.between;

import com.gating.operators.handler.TernaryOperatorTypeHandler;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BetweenStringHandler extends AbstractBetweenTypeHandler<String> {

    private final TernaryOperatorTypeHandler next;

    public boolean apply(Object val, String first, String last) {
        markImpression();
        if (val instanceof String) {
            return ((String) val).compareToIgnoreCase(first) >= 0 && ((String) val).compareToIgnoreCase(last) <= 0;
        } else {
            validateNotNull(next);
            return this.next.apply(val, first, last);
        }
    }
}
