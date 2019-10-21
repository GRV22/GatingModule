package com.gating.helpers;

import com.gating.enums.OperatorInfo;
import com.gating.operators.*;
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
        addOperator(new EqualsTo());
        addOperator(new NotEqualsTo());
        addOperator(new GreaterThanEqualsTo());
        addOperator(new GreaterThan());
        addOperator(new LessThanEqualsTo());
        addOperator(new LessThan());
        addOperator(new Between());
        addOperator(new AllOf());
        addOperator(new NoneOf());
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

    public Object getElementValue(final Object o) {
        if ("true".equals(((String) o).toLowerCase()) || "false".equals(((String) o).toLowerCase())) {
            return Boolean.parseBoolean(((String) o).toLowerCase());
        } else {
            try {
                return Integer.parseInt((String) o);
            } catch (final NumberFormatException ex) {
                return ((String) o).toLowerCase();
            }
        }
    }

}
