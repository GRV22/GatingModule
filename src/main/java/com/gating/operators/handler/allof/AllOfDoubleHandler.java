package com.gating.operators.handler.allof;

import com.gating.operators.handler.BinaryOperatorTypeHandler;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class AllOfDoubleHandler extends AbstractAllOfTypeHandler<Double> {

    private final BinaryOperatorTypeHandler next;

    @Override
    public boolean apply(final Object val, final String val1) {
        if (isNullOrEmpty(val)) {
            return true;
        } else if (val instanceof Double) {
            return Arrays.stream(val1.split(","))
                    .anyMatch(x -> (Double.compare((Double) val, Double.valueOf(x)) == 0));
        } else if (val instanceof Collection && ((Collection) val).stream().findFirst().get() instanceof Double) {
            return Arrays.stream(val1.split(","))
                    .map(Double::valueOf)
                    .collect(Collectors.toList())
                    .containsAll((Collection) val);
        } else {
            validateNotNull(next);
            return this.next.apply(val, val1);
        }
    }
}
