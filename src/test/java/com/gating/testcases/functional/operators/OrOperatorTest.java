package com.gating.testcases.functional.operators;

import com.gating.validator.GatingValidator;
import com.gating.validator.impl.GatingValidatorImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class OrOperatorTest {

    // Or Test cases

    private GatingValidator validator;

    @BeforeClass
    public void setUp() {
        validator = new GatingValidatorImpl();
    }

    @Test
    public void positiveEvaluateOrOperatorTest() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("age", 25);
        attributes.put("name", "ganesh");

        String feature = "Age or Name Feature";
        String expression = "age == 26 or name == ganesh";

        Assert.assertTrue(validator.isAllowed(expression, feature, attributes));
    }

    @Test
    public void negativeEvaluateOrOperatorTest() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("age", 25);
        attributes.put("name", "arshu");

        String feature = "Age or Name Feature";
        String expression = "age == 26 or name == ganesh";

        Assert.assertFalse(validator.isAllowed(expression, feature, attributes));
    }

}
