package com.gating.validator.impl;

import com.gating.helpers.InfixHelper;
import com.gating.helpers.PostfixHelper;
import com.gating.validator.GatingValidator;

import java.util.Map;

public class GatingValidatorImpl implements GatingValidator {

    private final InfixHelper infixHelper;
    private final PostfixHelper postfixHelper;

    public GatingValidatorImpl() {
        infixHelper = InfixHelper.getInstance();
        postfixHelper = PostfixHelper.getInstance();
    }

    public boolean isAllowed(String conditionalExperssion, String featureName, Map<String, Object> attributes) throws
            Exception {
        return postfixHelper.evaluate(infixHelper.convertToPostfix(conditionalExperssion), attributes);
    }

}
