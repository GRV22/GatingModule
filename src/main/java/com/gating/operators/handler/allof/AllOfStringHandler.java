package com.gating.operators.handler.allof;

import com.gating.operators.handler.BinaryOperatorTypeHandler;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
public class AllOfStringHandler extends AbstractAllOfTypeHandler<String> {

    private final BinaryOperatorTypeHandler next;

    public boolean apply(Object val, String val1) {
        markImpression();
        if (isNullOrEmpty(val)) {
            return true;
        } else if (val instanceof String) {
            final List<String> values = Arrays.asList(((String) val).split(","));
            return Arrays.asList(val1.split(",")).containsAll(values);
        } else if (val instanceof Collection && ((Collection)val).stream().findFirst().get() instanceof String) {
            return Arrays.asList(val1.split(",")).containsAll((Collection) val);
        } else {
            validateNotNull(next);
            return this.next.apply(val, val1);
        }
    }
}
