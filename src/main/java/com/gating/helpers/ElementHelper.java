package com.gating.helpers;

import com.gating.enums.OperatorInfo;
import com.gating.operators.*;
import com.gating.operators.handler.BinaryOperatorTypeHandler;
import com.gating.operators.handler.TernaryOperatorTypeHandler;
import com.gating.operators.handler.allof.AllOfDoubleHandler;
import com.gating.operators.handler.allof.AllOfIntegerHandler;
import com.gating.operators.handler.allof.AllOfStringHandler;
import com.gating.operators.handler.between.BetweenDoubleHandler;
import com.gating.operators.handler.between.BetweenIntegerHandler;
import com.gating.operators.handler.between.BetweenStringHandler;
import com.gating.operators.handler.equalsto.EqualsToBooleanHandler;
import com.gating.operators.handler.equalsto.EqualsToDoubleHandler;
import com.gating.operators.handler.equalsto.EqualsToIntegerHandler;
import com.gating.operators.handler.equalsto.EqualsToStringHandler;
import com.gating.operators.handler.greaterthan.GreaterThanDoubleHandler;
import com.gating.operators.handler.greaterthan.GreaterThanIntegerHandler;
import com.gating.operators.handler.greaterthan.GreaterThanStringHandler;
import com.gating.operators.handler.lessthan.LessThanDoubleHandler;
import com.gating.operators.handler.lessthan.LessThanIntegerHandler;
import com.gating.operators.handler.lessthan.LessThanStringHandler;
import com.gating.operators.handler.noneof.NoneOfDoubleHandler;
import com.gating.operators.handler.noneof.NoneOfIntegerHandler;
import com.gating.operators.handler.noneof.NoneOfStringHandler;
import com.gating.operators.impl.*;

import java.util.HashMap;
import java.util.Map;

public class ElementHelper {

    private Map<OperatorInfo, Operator> operatorInfoOperatorMap;

    private void addOperator(AbstractOperator operator) {
        operatorInfoOperatorMap.put(operator.getOperatorInfo(), operator);
    }

    private ElementHelper() {
        operatorInfoOperatorMap = new HashMap<OperatorInfo, Operator>();

        addOperator(new Or());
        addOperator(new And());

        final BinaryOperatorTypeHandler equalsToHandler = new EqualsToBooleanHandler(new EqualsToIntegerHandler(new EqualsToDoubleHandler(new EqualsToStringHandler(null))));
        addOperator(new EqualsTo(equalsToHandler));
        addOperator(new NotEqualsTo(equalsToHandler));

        final BinaryOperatorTypeHandler greaterThanHandler = new GreaterThanIntegerHandler(new GreaterThanDoubleHandler(new GreaterThanStringHandler(null)));
        addOperator(new GreaterThan(greaterThanHandler));
        addOperator(new LessThanEqualsTo(greaterThanHandler));

        final BinaryOperatorTypeHandler lessThanHandler = new LessThanIntegerHandler(new LessThanDoubleHandler(new LessThanStringHandler(null)));
        addOperator(new LessThan(lessThanHandler));
        addOperator(new GreaterThanEqualsTo(lessThanHandler));

        final TernaryOperatorTypeHandler betweenHandler = new BetweenIntegerHandler(new BetweenDoubleHandler(new BetweenStringHandler(null)));
        addOperator(new Between(betweenHandler));

        final BinaryOperatorTypeHandler allOfHandler = new AllOfIntegerHandler(new AllOfDoubleHandler(new AllOfStringHandler(null)));
        addOperator(new AllOf(allOfHandler));

        final BinaryOperatorTypeHandler noneOfHandler = new NoneOfIntegerHandler(new NoneOfDoubleHandler(new NoneOfStringHandler(null)));
        addOperator(new NoneOf(noneOfHandler));
    }

    private static class SingletonHelper {
        private static final ElementHelper INSTANCE = new ElementHelper();
    }

    public static ElementHelper getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public Operator getOperator(final OperatorInfo opInfo) {
        return operatorInfoOperatorMap.get(opInfo);
    }

}
