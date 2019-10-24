package com.gating.operators.handler.noneof;

import com.gating.operators.handler.BinaryOperatorTypeHandler;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class NoneOfIntegerHandler extends AbstractNoneOfTypeHandler<Integer> {

    private final BinaryOperatorTypeHandler next;

    @Override
    public boolean apply(Object val, String val1) {
        if (isNullOrEmpty(val)) {
            return true;
        } else if (val instanceof Integer) {
            return !Arrays.asList(val1.split(",")).stream()
                    .anyMatch(x -> ((Integer) val == Integer.valueOf(x)));
        } else if (val instanceof Collection && ((Collection) val).stream().findFirst().get() instanceof Integer) {
            return Collections.disjoint(Arrays.asList(val1.split(",")).stream()
                    .map(x -> Integer.valueOf(x))
                    .collect(Collectors.toList()), (Collection) val);
        } else {
            validateNotNull(next);
            return this.next.apply(val, val1);
        }
    }
}
