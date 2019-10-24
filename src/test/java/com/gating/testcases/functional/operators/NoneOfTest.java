package com.gating.testcases.functional.operators;

import com.gating.validator.GatingValidator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class NoneOfTest {

    // Noneof test cases

    @Test
    public void positiveEvaluteNoneOfTest() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("visitedLocations", "mumbai,delhi");

        String feature = "None Of User eligible if they visited these places Feature";
        String expression = "visitedLocations noneof gujrat,bangalore,indore";

        final GatingValidator validator = new GatingValidator();
        Assert.assertTrue(validator.isAllowed(expression, feature, attributes));
    }

    @Test
    public void negativeEvaluteNoneOfTest() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("visitedLocations", "mumbai,gujrat,delhi");

        String feature = "None Of User eligible if they visited these places Feature";
        String expression = "visitedLocations noneof gujrat,bangalore,indore";

        final GatingValidator validator = new GatingValidator();
        Assert.assertFalse(validator.isAllowed(expression, feature, attributes));
    }

}
