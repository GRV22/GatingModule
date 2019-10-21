package com.gating.helpers;

import com.gating.operators.*;

import java.util.HashMap;
import java.util.Map;

public class ElementHelper {

    private Map<OperatorInfo, Operator> operatorInfoOperatorMap;

    private ElementHelper() {
        operatorInfoOperatorMap = new HashMap<OperatorInfo, Operator>();
        operatorInfoOperatorMap.put(OperatorInfo.Or, new Or());
        operatorInfoOperatorMap.put(OperatorInfo.And, new And());
        operatorInfoOperatorMap.put(OperatorInfo.EqualsTo, new EqualsTo());
        operatorInfoOperatorMap.put(OperatorInfo.NotEqualsTo, new NotEqualsTo());
        operatorInfoOperatorMap.put(OperatorInfo.GreaterThanEqualsTo, new GreaterThanEqualsTo());
        operatorInfoOperatorMap.put(OperatorInfo.GreaterThan, new GreaterThan());
        operatorInfoOperatorMap.put(OperatorInfo.LessThanEqualsTo, new LessThanEqualsTo());
        operatorInfoOperatorMap.put(OperatorInfo.LessThan, new LessThan());
        operatorInfoOperatorMap.put(OperatorInfo.Between, new Between());
        operatorInfoOperatorMap.put(OperatorInfo.AllOf, new AllOf());
        operatorInfoOperatorMap.put(OperatorInfo.NoneOf, new NoneOf());
    }

    private static class SingletonHelper {
        private static final ElementHelper INSTANCE = new ElementHelper();
    }

    public static ElementHelper getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public boolean isOperator(final String element) {
        if (null == element) {
            return false;
        }
        return (null != OperatorInfo.getByName(element.toLowerCase()));
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
