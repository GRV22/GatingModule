package com.gating.testcases.functional.operators;

import com.gating.validator.GatingValidator;
import com.gating.validator.impl.GatingValidatorImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class EqualsToTest {

    private GatingValidator validator;

    @BeforeClass
    public void setUp() {
        validator = new GatingValidatorImpl();
    }

    @Test
    public void positiveEvaluteEqualsToBoolean() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("qualify", true);

        String feature = "Qualify Feature";
        String expression = "qualify == true";

        Assert.assertTrue(validator.isAllowed(expression, feature, attributes));
    }

    @Test
    public void positiveEvaluteEqualsToString() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("name", "Ganesh");

        String feature = "Name Feature";
        String expression = "name == Ganesh";

        Assert.assertTrue(validator.isAllowed(expression, feature, attributes));
    }


    @Test
    public void positiveEvaluteEqualsToInteger() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("age", 25);

        String feature = "Age Feature";
        String expression = "age == 25";

        Assert.assertTrue(validator.isAllowed(expression, feature, attributes));
    }

    @Test
    public void negativeEvaluteEqualsToBoolean() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("qualify", false);

        String feature = "Qualify Feature";
        String expression = "qualify == true";

        Assert.assertFalse(validator.isAllowed(expression, feature, attributes));
    }

    @Test
    public void negativeEvaluteEqualsToString() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("name", "arshu");

        String feature = "Name Feature";
        String expression = "name == ganesh";

        Assert.assertFalse(validator.isAllowed(expression, feature, attributes));
    }


    @Test
    public void negativeEvaluteEqualsToInteger() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("age", 26);

        String feature = "Age Feature";
        String expression = "age == 25";

        Assert.assertFalse(validator.isAllowed(expression, feature, attributes));
    }

}
