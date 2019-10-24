package com.gating.testcases.functional.operators;

import com.gating.validator.GatingValidator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class LessThanTest {

    // LessThan


    @Test
    public void positiveEvaluateLessThanOperatorTest() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("age", 25);

        String feature = "Age Less than Feature";
        String expression = "age < 30";

        final GatingValidator validator = new GatingValidator();
        Assert.assertTrue(validator.isAllowed(expression, feature, attributes));
    }

    @Test
    public void negativeEvaluateLessThanOperatorTest() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("age", 25);

        String feature = "Age Less than Feature";
        String expression = "age < 20";

        final GatingValidator validator = new GatingValidator();
        Assert.assertFalse(validator.isAllowed(expression, feature, attributes));
    }


}
