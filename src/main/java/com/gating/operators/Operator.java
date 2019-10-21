package com.gating.operators;

import java.util.List;

public interface Operator {
    int getPrecedenceOrder();
    int getNoOfOperands();
    String getOperatorIdentity();
    <T> Boolean apply(List<T> operands) throws Exception;
}
