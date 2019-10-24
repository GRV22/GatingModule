package com.gating.testcases.functional.operators;

import com.gating.validator.GatingValidator;
import com.gating.validator.impl.GatingValidatorImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class GreaterThanTest {


    // GreaterThan operator

    private GatingValidator validator;

    @BeforeClass
    public void setUp() {
        validator = new GatingValidatorImpl();
    }

    @Test
    public void positiveEvaluateGreaterThanOperatorTest() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("age", 25);

        String feature = "Age Greater than Feature";
        String expression = "age > 20";

        Assert.assertTrue(validator.isAllowed(expression, feature, attributes));
    }

    @Test
    public void negativeEvaluateGreaterThanOperatorTest() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("age", 25);

        String feature = "Age Greater than Feature";
        String expression = "age > 30";

        Assert.assertFalse(validator.isAllowed(expression, feature, attributes));
    }


}
