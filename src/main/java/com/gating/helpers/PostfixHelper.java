package com.gating.helpers;

import com.gating.operators.Operator;
import com.gating.operators.OperatorInfo;

import java.util.*;

public class PostfixHelper {

    private final ElementHelper helper = ElementHelper.getInstance();

    public boolean evaluate(String postfixExpression, Map<String, Object> attributes) throws Exception {
        Stack<Object> stack = new Stack<Object>();
        String[] expressionElements = postfixExpression.split(" ");
        for (final String element : expressionElements) {
            if (helper.isOperator(element)) {
                Operator operator = helper.getOperator(OperatorInfo.getByName(element.toLowerCase()));
                int noOfOperands = operator.getNoOfOperands();
                final List<Object> operands = new ArrayList<Object>();
                for (int i = 0; i < noOfOperands; ++i) {
                    operands.add(stack.pop());
                }
                Collections.reverse(operands);
                stack.push(operator.operate(operands));
            } else {
                if (null == attributes.get(element)) {
                    stack.push(helper.getElementValue(element));
                } else {
                    stack.push(attributes.get(element));
                }
            }
        }
        return (Boolean) stack.pop();
    }


}
