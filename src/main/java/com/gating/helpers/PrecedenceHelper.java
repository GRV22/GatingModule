package com.gating.helpers;

import com.gating.enums.OperatorInfo;

public class PrecedenceHelper {

    public int getPrecedence(String operator) {
        if (null == operator) {
            return -1;
        }
        return OperatorInfo.getPrecedence(operator.toLowerCase());
    }

}
