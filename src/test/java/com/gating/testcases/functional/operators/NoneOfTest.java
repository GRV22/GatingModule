package com.gating.testcases.functional.operators;

import com.gating.validator.GatingValidator;
import com.gating.validator.impl.GatingValidatorImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class NoneOfTest {

    // Noneof test cases

    private GatingValidator validator;

    @BeforeClass
    public void setUp() {
        validator = new GatingValidatorImpl();
    }

    @Test
    public void positiveEvaluteNoneOfTest() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("visitedLocations", "mumbai,delhi");

        String feature = "None Of User eligible if they visited these places Feature";
        String expression = "visitedLocations noneof gujrat,bangalore,indore";

        Assert.assertTrue(validator.isAllowed(expression, feature, attributes));
    }

    @Test
    public void negativeEvaluteNoneOfTest() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("visitedLocations", "mumbai,gujrat,delhi");

        String feature = "None Of User eligible if they visited these places Feature";
        String expression = "visitedLocations noneof gujrat,bangalore,indore";

        Assert.assertFalse(validator.isAllowed(expression, feature, attributes));
    }

}
