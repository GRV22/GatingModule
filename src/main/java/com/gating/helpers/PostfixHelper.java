package com.gating.helpers;

import com.gating.operators.Operator;
import com.gating.enums.OperatorInfo;

import java.util.*;

public class PostfixHelper {

    private final ElementHelper helper = ElementHelper.getInstance();

    private PostfixHelper() {}

    private static class SingletonHelper {
        private static final PostfixHelper INSTANCE = new PostfixHelper();
    }

    public static PostfixHelper getInstance() {
        return PostfixHelper.SingletonHelper.INSTANCE;
    }

    public boolean evaluate(String postfixExpression, Map<String, Object> attributes) throws Exception {
        Stack<Object> stack = new Stack<>();
        String[] expressionElements = postfixExpression.split(" ");
        for (final String element : expressionElements) {
            if (OperatorInfo.isExist(element)) {
                Operator operator = helper.getOperator(OperatorInfo.getByName(element.toLowerCase()));
                int noOfOperands = operator.getNoOfOperands();
                final List<Object> operands = new ArrayList<>();
                for (int i = 0; i < noOfOperands; ++i) {
                    operands.add(stack.pop());
                }
                Collections.reverse(operands);
                stack.push(operator.apply(operands));
            } else {
                if (attributes.containsKey(element)) {
                    stack.push(attributes.get(element));
                } else {
                    stack.push(element);
                }
            }
        }
        return (Boolean) stack.pop();
    }


}
