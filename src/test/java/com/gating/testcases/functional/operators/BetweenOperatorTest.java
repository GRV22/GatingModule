package com.gating.testcases.functional.operators;

import com.gating.validator.GatingValidator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class BetweenOperatorTest {


    // Between Operator Test cases

    @Test
    public void postiveEvaluateBetweenOperatorTest() throws Exception {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("age", 25);

        String feature = "Age Between Feature";
        String expression = "age between 20 30";

        final GatingValidator validator = new GatingValidator();
        Assert.assertTrue(validator.isAllowed(expression, feature, attributes));
    }


    @Test
    public void negativeEvaluateBetweenOperatorTest() throws Exception {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("age", 25);

        String feature = "Age Between Feature";
        String expression = "age between 30 40";

        final GatingValidator validator = new GatingValidator();
        Assert.assertFalse(validator.isAllowed(expression, feature, attributes));
    }


}
