package com.gating.operators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllOf extends AbstractOperator {

    public AllOf() {
        super(OperatorInfo.AllOf);
    }

    public <T> Boolean operate(List<T> operands) throws Exception {
        validateOperands(operands);
        for (T operand : operands) {
            if (!(operand instanceof String)) {
                throw new Exception("For AllOf Operation operands should be string type");
            }
        }
        List<String> operand1List = Arrays.asList(((String)operands.get(0)).split(","));
        List<String> operand2List = Arrays.asList(((String)operands.get(1)).split(","));
        return operand2List.containsAll(operand1List);
    }
}
