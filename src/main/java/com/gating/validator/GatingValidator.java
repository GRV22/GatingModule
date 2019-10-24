package com.gating.validator;

import com.gating.helpers.InfixHelper;
import com.gating.helpers.PostfixHelper;

import java.util.Map;

public class GatingValidator {

    private final InfixHelper infixHelper;
    private final PostfixHelper postfixHelper;

    public GatingValidator() {
        infixHelper = InfixHelper.getInstance();
        postfixHelper = PostfixHelper.getInstance();
    }

    private void printInformationOnEnter(String feature, String infixExpresson, String postfixExpression) {
        System.out.println("Inside Gating System ...");
        System.out.println("Feature : " + feature);
        System.out.println("Conditional Expression :");
        System.out.println(infixExpresson);
        System.out.println("Postfix Expression :");
        System.out.println(postfixExpression);
        System.out.println();
    }

    public boolean isAllowed(String conditionalExperssion, String featureName, Map<String, Object> attributes) throws
            Exception {
        String postfix = infixHelper.convertToPostfix(conditionalExperssion);
        printInformationOnEnter(featureName, conditionalExperssion, postfix);
        return postfixHelper.evaluate(postfix, attributes);
    }

}
