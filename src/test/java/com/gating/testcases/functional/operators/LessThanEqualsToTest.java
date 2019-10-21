package com.gating.testcases.functional.operators;

import com.gating.validator.GatingValidator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class LessThanEqualsToTest {

    // LessThanEqualsTo


    @Test
    public void positiveEvaluateLessThanEqualsToOperatorTest() throws Exception {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("age", 25);

        String feature = "Age Less than EqualsTo Feature";
        String expression = "age <= 25";

        final GatingValidator validator = new GatingValidator();
        Assert.assertTrue(validator.isAllowed(expression, feature, attributes));
    }

    @Test
    public void negativeEvaluateLessThanEqualsToOperatorTest() throws Exception {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("age", 25);

        String feature = "Age Less than EqualsTo Feature";
        String expression = "age <= 20";

        final GatingValidator validator = new GatingValidator();
        Assert.assertFalse(validator.isAllowed(expression, feature, attributes));
    }


}
