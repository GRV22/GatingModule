package com.gating.testcases.functional.operators;

import com.gating.validator.GatingValidator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class EqualsToTest {

    @Test
    public void positiveEvaluteEqualsToBoolean() throws Exception {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("qualify", true);

        String feature = "Qualify Feature";
        String expression = "qualify == true";

        final GatingValidator validator = new GatingValidator();
        Assert.assertTrue(validator.isAllowed(expression, feature, attributes));
    }

    @Test
    public void positiveEvaluteEqualsToString() throws Exception {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("name", "Ganesh");

        String feature = "Name Feature";
        String expression = "name == ganesh";

        final GatingValidator validator = new GatingValidator();
        Assert.assertTrue(validator.isAllowed(expression, feature, attributes));
    }


    @Test
    public void positiveEvaluteEqualsToInteger() throws Exception {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("age", 25);

        String feature = "Age Feature";
        String expression = "age == 25";

        final GatingValidator validator = new GatingValidator();
        Assert.assertTrue(validator.isAllowed(expression, feature, attributes));
    }

    @Test
    public void negativeEvaluteEqualsToBoolean() throws Exception {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("qualify", false);

        String feature = "Qualify Feature";
        String expression = "qualify == true";

        final GatingValidator validator = new GatingValidator();
        Assert.assertFalse(validator.isAllowed(expression, feature, attributes));
    }

    @Test
    public void negativeEvaluteEqualsToString() throws Exception {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("name", "arshu");

        String feature = "Name Feature";
        String expression = "name == ganesh";

        final GatingValidator validator = new GatingValidator();
        Assert.assertFalse(validator.isAllowed(expression, feature, attributes));
    }


    @Test
    public void negativeEvaluteEqualsToInteger() throws Exception {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("age", 26);

        String feature = "Age Feature";
        String expression = "age == 25";

        final GatingValidator validator = new GatingValidator();
        Assert.assertFalse(validator.isAllowed(expression, feature, attributes));
    }

}
