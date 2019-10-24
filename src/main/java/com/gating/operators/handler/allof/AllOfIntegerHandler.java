package com.gating.operators.handler.allof;

import com.gating.operators.handler.BinaryOperatorTypeHandler;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class AllOfIntegerHandler extends AbstractAllOfTypeHandler<Integer> {

    private final BinaryOperatorTypeHandler next;

    @Override
    public boolean apply(Object val, String val1) {
        if (isNullOrEmpty(val)) {
            return true;
        } else if (val instanceof Integer) {
            return Arrays.stream(val1.split(","))
                    .anyMatch(x -> (val == Integer.valueOf(x)));
        } else if (val instanceof Collection && ((Collection) val).stream().findFirst().get() instanceof Integer) {
            return Arrays.stream(val1.split(","))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList())
                    .containsAll((Collection) val);
        } else {
            validateNotNull(next);
            return this.next.apply(val, val1);
        }
    }
}
