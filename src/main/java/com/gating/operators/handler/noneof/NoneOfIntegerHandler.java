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
    public boolean apply(final Object val, final String val1) {
        if (isNullOrEmpty(val)) {
            return true;
        } else if (val instanceof Integer) {
            return Arrays.stream(val1.split(","))
                    .noneMatch(x -> (val == Integer.valueOf(x)));
        } else if (val instanceof Collection && ((Collection) val).stream().findFirst().get() instanceof Integer) {
            return Collections.disjoint(Arrays.stream(val1.split(","))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList()), (Collection) val);
        } else {
            validateNotNull(next);
            return this.next.apply(val, val1);
        }
    }
}
