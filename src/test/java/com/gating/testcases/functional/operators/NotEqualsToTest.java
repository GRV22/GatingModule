package com.gating.testcases.functional.operators;

import com.gating.validator.GatingValidator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class NotEqualsToTest {

    /**
     * Not Equals To Test
     **/


    @Test
    public void postiveEvaluteNotEqualsToBooleanTest() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("qualify", false);

        String feature = "Qualify Feature";
        String expression = "qualify != true";

        final GatingValidator validator = new GatingValidator();
        Assert.assertTrue(validator.isAllowed(expression, feature, attributes));
    }

    @Test
    public void negativeEvaluteNotEqualsToBooleanTest() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("qualify", true);

        String feature = "Qualify Feature";
        String expression = "qualify != true";

        final GatingValidator validator = new GatingValidator();
        Assert.assertFalse(validator.isAllowed(expression, feature, attributes));
    }

    @Test
    public void positiveEvaluteNotEqualsToStringTest() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("name", "arshu");

        String feature = "Not Name Feature";
        String expression = "name != ganesh";

        final GatingValidator validator = new GatingValidator();
        Assert.assertTrue(validator.isAllowed(expression, feature, attributes));
    }

    @Test
    public void negativeEvaluteNotEqualsToStringTest() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("name", "ganesh");

        String feature = "Not Name Feature";
        String expression = "name != ganesh";

        final GatingValidator validator = new GatingValidator();
        Assert.assertFalse(validator.isAllowed(expression, feature, attributes));
    }


    @Test
    public void postiveEvaluteNotEqualsToIntegerTest() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("age", 26);

        String feature = "Age Feature";
        String expression = "age != 25";

        final GatingValidator validator = new GatingValidator();
        Assert.assertTrue(validator.isAllowed(expression, feature, attributes));
    }

    @Test
    public void negativeEvaluteNotEqualsToIntegerTest() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("age", 25);

        String feature = "Age Feature";
        String expression = "age != 25";

        final GatingValidator validator = new GatingValidator();
        Assert.assertFalse(validator.isAllowed(expression, feature, attributes));
    }

}
