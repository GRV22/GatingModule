package com.gating.validator;

import com.gating.helpers.InfixHelper;
import com.gating.helpers.PostfixHelper;

import java.util.Map;

public class GatingValidator {

    private InfixHelper infixHelper = new InfixHelper();
    private PostfixHelper postfixHelper = new PostfixHelper();

    public boolean isAllowed(String conditionalExperssion, String featureName, Map<String, Object> attributes) throws Exception {
        return postfixHelper.evaluate(infixHelper.convertToPostfix(conditionalExperssion), attributes);
    }

}
