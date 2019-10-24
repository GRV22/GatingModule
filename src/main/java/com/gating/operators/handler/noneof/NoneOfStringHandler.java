package com.gating.operators.handler.noneof;

import com.gating.operators.handler.BinaryOperatorTypeHandler;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class NoneOfStringHandler extends AbstractNoneOfTypeHandler<String> {

    private final BinaryOperatorTypeHandler next;

    @Override
    public boolean apply(final Object val, final String val1) {
        if (isNullOrEmpty(val)) {
            return true;
        } else if (val instanceof String) {
            final List<String> values = Arrays.asList(((String) val).split(","));
            return Collections.disjoint(Arrays.asList(val1.split(",")), values);
        } else if (val instanceof Collection && ((Collection) val).stream().findFirst().get() instanceof String) {
            return Collections.disjoint(Arrays.asList(val1.split(",")), (Collection) val);
        } else {
            validateNotNull(next);
            return this.next.apply(val, val1);
        }
    }
}
