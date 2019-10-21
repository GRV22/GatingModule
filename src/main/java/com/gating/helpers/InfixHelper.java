package com.gating.helpers;

import java.util.Stack;

public class InfixHelper {

    private final ElementHelper helper = ElementHelper.getInstance();
    private final PrecedenceHelper precedenceHelper = new PrecedenceHelper();

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
            } else if (helper.isOperator(element)) {
                while (!stack.isEmpty() && precedenceHelper.getPrecedence(stack.peek()) >= precedenceHelper.getPrecedence(element)) {
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
