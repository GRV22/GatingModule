package com.gating.testcases.functional.operators;

import com.gating.validator.GatingValidator;
import com.gating.validator.impl.GatingValidatorImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class GreaterThanEqualsToTest {


    // GreaterThanEqualsTo

    private GatingValidator validator;

    @BeforeClass
    public void setUp() {
        validator = new GatingValidatorImpl();
    }

    @Test
    public void positiveEvaluateGreaterThanEqualsToOperatorTest() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("age", 25);

        String feature = "Age Greater than EqualsTo Feature";
        String expression = "age >= 25";

        Assert.assertTrue(validator.isAllowed(expression, feature, attributes));
    }

    @Test
    public void negativeEvaluateGreaterThanEqualsToOperatorTest() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("age", 25);

        String feature = "Age Greater than EqualsTo Feature";
        String expression = "age >= 30";

        Assert.assertFalse(validator.isAllowed(expression, feature, attributes));
    }
}
