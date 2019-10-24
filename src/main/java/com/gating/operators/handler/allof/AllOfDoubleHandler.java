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
    public boolean apply(Object val, String val1) {
        markImpression();
        if (isNullOrEmpty(val)) {
            return true;
        } else if (val instanceof Double) {
            return Arrays.asList(val1.split(",")).stream()
                    .anyMatch(x -> (Double.compare((Double) val ,Double.valueOf(x)) == 0));
        } else if (val instanceof Collection && ((Collection) val).stream().findFirst().get() instanceof Double) {
            return Arrays.asList(val1.split(",")).stream()
                    .map(x -> Double.valueOf(x))
                    .collect(Collectors.toList())
                    .containsAll((Collection) val);
        } else {
            validateNotNull(next);
            return this.next.apply(val, val1);
        }
    }
}
