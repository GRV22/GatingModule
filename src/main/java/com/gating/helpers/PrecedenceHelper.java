package com.gating.helpers;

import com.gating.operators.OperatorInfo;

public class PrecedenceHelper {

    public int getPrecedence(String operator) {
        if (null == operator) {
            return -1;
        }
        OperatorInfo operatorInfo = OperatorInfo.getByName(operator.toLowerCase());
        if (null != operatorInfo) {
            return operatorInfo.getPrecedenceOrder();
        }
        return -1;
    }

}
