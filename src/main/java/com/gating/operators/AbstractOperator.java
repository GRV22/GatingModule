package com.gating.operators;

import java.util.List;

public abstract class AbstractOperator implements Operator {

    protected OperatorInfo info;

    public AbstractOperator(final OperatorInfo operatorInfo) {
        this.info = operatorInfo;
    }

    public int getPrecedenceOrder() {
        return info.getPrecedenceOrder();
    }

    public int getNoOfOperands() {
        return info.getNoOfOperands();
    }

    public String getOperatorIdentity() {
        return info.getIdentity();
    }


    public boolean isOperandsEligible(List operands) {
        return (operands != null) && (getNoOfOperands() == operands.size());
    }

    public void validateOperands(List operands) throws Exception {
        if (!isOperandsEligible(operands)) {
            throw new Exception(info.getIdentity() + " don't have expected no of operands");
        }
    }

}
