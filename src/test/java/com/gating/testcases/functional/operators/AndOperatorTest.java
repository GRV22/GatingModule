package com.gating.testcases.functional.operators;

import com.gating.validator.GatingValidator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class AndOperatorTest {

    // And Test Cases

    @Test
    public void positiveEvaluateAndOperatorTest() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("age", 25);
        attributes.put("name", "arshu");

        String feature = "Age and Name Feature";
        String expression = "age == 25 and name == arshu";

        final GatingValidator validator = new GatingValidator();
        Assert.assertTrue(validator.isAllowed(expression, feature, attributes));
    }

    @Test
    public void negativeEvaluateAndOperatorTest() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("age", 25);
        attributes.put("name", "ganesh");

        String feature = "Age and Name Feature";
        String expression = "age == 25 and name == arshu";

        final GatingValidator validator = new GatingValidator();
        Assert.assertFalse(validator.isAllowed(expression, feature, attributes));
    }

}
