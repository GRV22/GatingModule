package com.gating.testcases.functional.operators;

import com.gating.validator.GatingValidator;
import com.gating.validator.impl.GatingValidatorImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class NotEqualsToTest {

    /**
     * Not Equals To Test
     **/

    private GatingValidator validator;

    @BeforeClass
    public void setUp() {
        validator = new GatingValidatorImpl();
    }


    @Test
    public void postiveEvaluteNotEqualsToBooleanTest() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("qualify", false);

        String feature = "Qualify Feature";
        String expression = "qualify != true";

        Assert.assertTrue(validator.isAllowed(expression, feature, attributes));
    }

    @Test
    public void negativeEvaluteNotEqualsToBooleanTest() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("qualify", true);

        String feature = "Qualify Feature";
        String expression = "qualify != true";

        Assert.assertFalse(validator.isAllowed(expression, feature, attributes));
    }

    @Test
    public void positiveEvaluteNotEqualsToStringTest() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("name", "arshu");

        String feature = "Not Name Feature";
        String expression = "name != ganesh";

        Assert.assertTrue(validator.isAllowed(expression, feature, attributes));
    }

    @Test
    public void negativeEvaluteNotEqualsToStringTest() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("name", "ganesh");

        String feature = "Not Name Feature";
        String expression = "name != ganesh";

        Assert.assertFalse(validator.isAllowed(expression, feature, attributes));
    }


    @Test
    public void postiveEvaluteNotEqualsToIntegerTest() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("age", 26);

        String feature = "Age Feature";
        String expression = "age != 25";

        Assert.assertTrue(validator.isAllowed(expression, feature, attributes));
    }

    @Test
    public void negativeEvaluteNotEqualsToIntegerTest() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("age", 25);

        String feature = "Age Feature";
        String expression = "age != 25";

        Assert.assertFalse(validator.isAllowed(expression, feature, attributes));
    }

}
