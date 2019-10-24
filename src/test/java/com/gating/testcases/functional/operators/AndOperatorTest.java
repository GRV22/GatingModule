package com.gating.testcases.functional.operators;

import com.gating.validator.GatingValidator;
import com.gating.validator.impl.GatingValidatorImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class AndOperatorTest {

    // And Test Cases

    private GatingValidator validator;

    @BeforeClass
    public void setUp() {
        validator = new GatingValidatorImpl();
    }

    @Test
    public void positiveEvaluateAndOperatorTest() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("age", 25);
        attributes.put("name", "arshu");

        String feature = "Age and Name Feature";
        String expression = "age == 25 and name == arshu";

        Assert.assertTrue(validator.isAllowed(expression, feature, attributes));
    }

    @Test
    public void negativeEvaluateAndOperatorTest() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("age", 25);
        attributes.put("name", "ganesh");

        String feature = "Age and Name Feature";
        String expression = "age == 25 and name == arshu";

        Assert.assertFalse(validator.isAllowed(expression, feature, attributes));
    }

}
