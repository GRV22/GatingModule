package com.gating.testcases.functional.operators;

import com.gating.validator.GatingValidator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AllOfOperatorTest {

    // Allof test cases

    @Test
    public void positiveEvaluteAllOffTest() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("visitedLocations", "mumbai,gujrat,delhi");

        String feature = "All Of User eligible if they visited these places Feature";
        String expression = "visitedLocations allof delhi,gujrat,bangalore,indore,mumbai";

        final GatingValidator validator = new GatingValidator();
        Assert.assertTrue(validator.isAllowed(expression, feature, attributes));
    }

    @Test
    public void negativeEvaluteAllOffTest() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("visitedLocations", "mumbai,gujrat,delhi");

        String feature = "All Of User eligible if they visited these places Feature";
        String expression = "visitedLocations allof delhi,gujrat,bangalore,indore";

        final GatingValidator validator = new GatingValidator();
        Assert.assertFalse(validator.isAllowed(expression, feature, attributes));
    }

    @Test
    public void positiveEvaluteAllOffListTest() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("visitedLocations", Arrays.asList("mumbai", "gujrat", "delhi"));

        String feature = "All Of User eligible if they visited these places Feature";
        String expression = "visitedLocations allof delhi,gujrat,bangalore,indore,mumbai";

        final GatingValidator validator = new GatingValidator();
        Assert.assertTrue(validator.isAllowed(expression, feature, attributes));
    }

    @Test
    public void negativeEvaluteAllOffListTest() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("visitedLocations", Arrays.asList("mumbai", "gujrat", "delhi"));

        String feature = "All Of User eligible if they visited these places Feature";
        String expression = "visitedLocations allof delhi,gujrat,bangalore,indore";

        final GatingValidator validator = new GatingValidator();
        Assert.assertFalse(validator.isAllowed(expression, feature, attributes));
    }

    @Test
    public void positiveEvaluteAllOffEmptyListTest() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("visitedLocations", Arrays.asList());

        String feature = "All Of User eligible if they visited these places Feature";
        String expression = "visitedLocations allof delhi,gujrat,bangalore,indore,mumbai";

        final GatingValidator validator = new GatingValidator();
        Assert.assertTrue(validator.isAllowed(expression, feature, attributes));
    }

    @Test
    public void positiveEvaluteAllOffNullTest() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("visitedLocations", null);

        String feature = "All Of User eligible if they visited these places Feature";
        String expression = "visitedLocations allof delhi,gujrat,bangalore,indore,mumbai";

        final GatingValidator validator = new GatingValidator();
        Assert.assertTrue(validator.isAllowed(expression, feature, attributes));
    }

}
