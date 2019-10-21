package com.gating.helpers;

import com.gating.enums.OperatorInfo;

import java.util.Stack;

public class InfixHelper {

    private InfixHelper() {}

    private static class SingletonHelper {
        private static final InfixHelper INSTANCE = new InfixHelper();
    }

    public static InfixHelper getInstance() {
        return InfixHelper.SingletonHelper.INSTANCE;
    }

    public String convertToPostfix(String expression) {
        final StringBuilder sb = new StringBuilder();
        final String[] elements = expression.split(" ");
        final Stack<String> stack = new Stack<String>();

        for (final String element : elements) {
            if (element.equals("(")) {
                stack.push(element);
            } else if (element.equals(")")) {
                String popElement;
                while (!stack.isEmpty() && !(popElement = stack.pop()).equals("(")) {
                    sb.append(popElement).append(" ");
                }
            } else if (OperatorInfo.isExist(element)) {
                while (!stack.isEmpty() && OperatorInfo.getPrecedence(stack.peek()) >= OperatorInfo.getPrecedence(element)) {
                    sb.append(stack.pop()).append(" ");
                }
                stack.push(element);
            } else {
                sb.append(element).append(" ");
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        return sb.toString();
    }

}
