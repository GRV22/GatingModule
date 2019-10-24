package com.gating.testcases.functional;

import com.gating.validator.GatingValidator;
import com.gating.validator.impl.GatingValidatorImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GateValidatorTest {

    private GatingValidator validator;

    @BeforeClass
    public void setUp() {
        validator = new GatingValidatorImpl();
    }

    @Test
    public void positiveSelectedAgeGroupDelhiUser() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("age", 35);
        attributes.put("city", "delhi");

        String feature = "Selected  age group for delhi user";
        String expression = "city == delhi and age >= 20";

        Assert.assertTrue(validator.isAllowed(expression, feature, attributes));
    }

    @Test
    public void negativeSelectedAgeGroupDelhiUser() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("age", 35);
        attributes.put("city", "mumbai");

        String feature = "Selected  age group for delhi user";
        String expression = "city == delhi and age >= 20";

        Assert.assertFalse(validator.isAllowed(expression, feature, attributes));
    }

    @Test
    public void positiveSelectedLocationTest() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("age", 25);
        attributes.put("city", "Mumbai");
        attributes.put("pincode", "234567");
        attributes.put("accountType", "PREMIUM");

        String feature = "Selected location and age group for not free user";
        String expression = "age between 20 30 and ( city == Delhi or city == Mumbai ) and ( pincode != 34556 or " +
                "accountType != free )";

        Assert.assertTrue(validator.isAllowed(expression, feature, attributes));

    }

    @Test
    public void negativeSelectedLocationTest() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("age", 25);
        attributes.put("city", "Bangalore");
        attributes.put("pincode", "234567");
        attributes.put("accountType", "PREMIUM");

        String feature = "Selected location and age group for not free user";
        String expression = "age between 20 30 and ( city == Delhi or city == Mumbai ) and ( pincode != 34556 or " +
                "accountType != free )";

        Assert.assertFalse(validator.isAllowed(expression, feature, attributes));

    }

    @Test
    public void positiveAgeAndGenderTest() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("age", 25);
        attributes.put("gender", "male");

        String feature = "Age and gender Feature";
        String expression = "age between 24 60 and gender == male";

        Assert.assertTrue(validator.isAllowed(expression, feature, attributes));

    }

    @Test
    public void negativeAgeAndGenderTest() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("age", 68);
        attributes.put("gender", "male");

        String feature = "Age and gender Feature";
        String expression = "age between 24 60 and gender == male";

        Assert.assertFalse(validator.isAllowed(expression, feature, attributes));
    }


    @Test
    public void postivePastPurchaseNotBelongsToCitiesTest1() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("age", 30);
        attributes.put("lastpurchasedCities", "delhi,ahemdabad,indore");
        attributes.put("last30DaysPurchaseAmount", 2000);

        String feature = "Past purchase and purchase doesn't belongs to cities";

        List<String> equivalentExpressions = new ArrayList<>();
        equivalentExpressions.add("last30DaysPurchaseAmount < 3000 and lastpurchasedCities noneof hyderabad,bangalore" +
                " or age >= 40");
        equivalentExpressions.add("( last30DaysPurchaseAmount < 3000 and lastpurchasedCities noneof hyderabad," +
                "bangalore ) or age >= 40");
        equivalentExpressions.add("last30DaysPurchaseAmount < 3000 and ( lastpurchasedCities noneof hyderabad," +
                "bangalore ) or age >= 40");
        equivalentExpressions.add("lastpurchasedCities noneof hyderabad,bangalore and last30DaysPurchaseAmount < 3000" +
                " or age >= 40");


        for (final String expression : equivalentExpressions) {
            Assert.assertTrue(validator.isAllowed(expression, feature, attributes));
        }
    }


    @Test
    public void postivePastPurchaseNotBelongsToCitiesTest2() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("age", 40);
        attributes.put("lastpurchasedCities", "hyderabad,ahemdabad,indore");
        attributes.put("last30DaysPurchaseAmount", 5000);

        String feature = "Past purchase and purchase doesn't belongs to cities";

        List<String> equivalentExpressions = new ArrayList<>();
        equivalentExpressions.add("last30DaysPurchaseAmount < 3000 and lastpurchasedCities noneof hyderabad,bangalore" +
                " or age >= 40");
        equivalentExpressions.add("( last30DaysPurchaseAmount < 3000 and lastpurchasedCities noneof hyderabad," +
                "bangalore ) or age >= 40");
        equivalentExpressions.add("last30DaysPurchaseAmount < 3000 and ( lastpurchasedCities noneof hyderabad," +
                "bangalore ) or age >= 40");
        equivalentExpressions.add("lastpurchasedCities noneof hyderabad,bangalore and last30DaysPurchaseAmount < 3000" +
                " or age >= 40");


        for (final String expression : equivalentExpressions) {
            Assert.assertTrue(validator.isAllowed(expression, feature, attributes));
        }
    }


    @Test
    public void negativePastPurchaseNotBelongsToCitiesTest() throws Exception {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("age", 30);
        attributes.put("lastpurchasedCities", "hyderabad,ahemdabad,indore");
        attributes.put("last30DaysPurchaseAmount", 2000);

        String feature = "Past purchase and purchase doesn't belongs to cities";

        List<String> equivalentExpressions = new ArrayList<>();
        equivalentExpressions.add("last30DaysPurchaseAmount < 3000 and lastpurchasedCities noneof hyderabad,bangalore" +
                " or age >= 40");
        equivalentExpressions.add("( last30DaysPurchaseAmount < 3000 and lastpurchasedCities noneof hyderabad," +
                "bangalore ) or age >= 40");
        equivalentExpressions.add("last30DaysPurchaseAmount < 3000 and ( lastpurchasedCities noneof hyderabad," +
                "bangalore ) or age >= 40");
        equivalentExpressions.add("lastpurchasedCities noneof hyderabad,bangalore and last30DaysPurchaseAmount < 3000" +
                " or age >= 40");


        for (final String expression : equivalentExpressions) {
            Assert.assertFalse(validator.isAllowed(expression, feature, attributes));
        }
    }

}
