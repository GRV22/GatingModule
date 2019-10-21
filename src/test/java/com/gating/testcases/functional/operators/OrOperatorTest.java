package com.gating.testcases.functional.operators;

import com.gating.validator.GatingValidator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class OrOperatorTest {

    // Or Test cases

    @Test
    public void positiveEvaluateOrOperatorTest() throws Exception {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("age", 25);
        attributes.put("name", "ganesh");

        String feature = "Age or Name Feature";
        String expression = "age == 26 or name == ganesh";

        final GatingValidator validator = new GatingValidator();
        Assert.assertTrue(validator.isAllowed(expression, feature, attributes));
    }

    @Test
    public void negativeEvaluateOrOperatorTest() throws Exception {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("age", 25);
        attributes.put("name", "arshu");

        String feature = "Age or Name Feature";
        String expression = "age == 26 or name == ganesh";

        final GatingValidator validator = new GatingValidator();
        Assert.assertFalse(validator.isAllowed(expression, feature, attributes));
    }

}
