package com.gating.operators;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OperatorInfo {
    Or("or", 10, 2),
    And("and", 20, 2),
    EqualsTo("==", 30, 2),
    NotEqualsTo("!=", 30, 2),
    GreaterThanEqualsTo(">=", 30, 2),
    GreaterThan(">", 30, 2),
    LessThanEqualsTo("<=", 30, 2),
    LessThan("<", 30, 2),
    Between("between", 60, 3),
    AllOf("allof", 60, 2),
    NoneOf("noneof", 60, 2);

    private String identity;
    private int precedenceOrder;
    private int noOfOperands;

    public static OperatorInfo getByName(String identity) {
        for(final OperatorInfo operatorInfo: OperatorInfo.values()) {
            if (operatorInfo.getIdentity().equals(identity.toLowerCase())) {
                return operatorInfo;
            }
        }
        return null;
    }
}
