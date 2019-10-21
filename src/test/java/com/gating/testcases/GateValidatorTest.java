package com.gating.testcases;

import com.gating.attributes.AttributeBuilder;
import com.gating.enums.AccountType;
import com.gating.enums.Attribute;
import com.gating.enums.Gender;
import com.gating.helpers.InfixHelper;
import com.gating.validator.GatingValidator;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class GateValidatorTest {

    private Map<String, String> getFetauresExpression() {
        HashMap<String, String> featureConditionalExpressionMap = new HashMap<String, String>();
        featureConditionalExpressionMap.put("Adult Man", "age between 24 60 and gender == MALE");
//        featureConditionalExpressionMap.put("Premium Account and age >= 40", "accountType == PREMIUM and age >= 40");
//        featureConditionalExpressionMap.put("Offers in countries", "country == India or country == Srilanka");
//        featureConditionalExpressionMap.put("Eligible for X Discount", "age between 20 30 and ( city == Delhi or city == Mumbai ) and ( zipcode != 12345 or accountType != FREE )");
        return featureConditionalExpressionMap;
    }

    @Test
    public void gateDefaultValidator() throws Exception {
        final AttributeBuilder builder = new AttributeBuilder();
        builder.add(Attribute.NAME, "Arshu");
        builder.add(Attribute.AGE, 25);
        builder.add(Attribute.GENDER, Gender.MALE);
        builder.add(Attribute.ACCOUNTTYPE, AccountType.PREMIUM);
        builder.add(Attribute.EMAILID, "arshu@gmail.com");
        builder.add(Attribute.ZIPCODE, "345678");
        builder.add(Attribute.STATE, "Bangalore");
        builder.add(Attribute.COUNTRY, "India");

        final GatingValidator validator = new GatingValidator();

        Map<String, String> fetauresExpression = getFetauresExpression();
        for (String feature: fetauresExpression.keySet()) {
            String expression = fetauresExpression.get(feature);
            if (validator.isAllowed(expression, feature, builder.getResult())) {
                System.out.println("User is eligible for this feature : " + feature);
            } else {
                System.out.println("Sorry ! User isn't eligible for this feature : " + feature);
            }
        }
    }

    @Test
    public void testInfixHelper() {
        String test = "age between 24 60 and gender == MALE";
        InfixHelper infixHelper = new InfixHelper();
        String toPostfix = infixHelper.convertToPostfix(test);
        System.out.println(toPostfix);
    }

    /** Equals To Test **/


    @Test
    public void evaluteEqualsToBoolean() throws Exception {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("qualify", true);

        String feature = "Qualify Feature";
        String expression = "qualify == true";

        final GatingValidator validator = new GatingValidator();
        if (validator.isAllowed(expression, feature, attributes)) {
            System.out.println("User is eligible for this feature : " + feature);
        } else {
            System.out.println("Sorry ! User isn't eligible for this feature : " + feature);
        }
    }

    @Test
    public void evaluteEqualsToString() throws Exception {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("name", "Ganesh");

        String feature = "Name Feature";
        String expression = "name == ganesh";

        final GatingValidator validator = new GatingValidator();
        if (validator.isAllowed(expression, feature, attributes)) {
            System.out.println("User is eligible for this feature : " + feature);
        } else {
            System.out.println("Sorry ! User isn't eligible for this feature : " + feature);
        }
    }


    @Test
    public void evaluteEqualsToInteger() throws Exception {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("age", 25);

        String feature = "Age Feature";
        String expression = "age == 25";

        final GatingValidator validator = new GatingValidator();
        if (validator.isAllowed(expression, feature, attributes)) {
            System.out.println("User is eligible for this feature : " + feature);
        } else {
            System.out.println("Sorry ! User isn't eligible for this feature : " + feature);
        }
    }

    // Or Test cases

    @Test
    public void evaluateOrOperatorTest1() throws Exception {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("age", 25);
        attributes.put("name", "ganesh");

        String feature = "Age or Name Feature";
        String expression = "age == 26 or name == ganesh";

        final GatingValidator validator = new GatingValidator();
        if (validator.isAllowed(expression, feature, attributes)) {
            System.out.println("User is eligible for this feature : " + feature);
        } else {
            System.out.println("Sorry ! User isn't eligible for this feature : " + feature);
        }
    }

    @Test
    public void evaluateOrOperatorTest2() throws Exception {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("age", 25);
        attributes.put("name", "arshu");

        String feature = "Age or Name Feature";
        String expression = "age == 26 or name == ganesh";

        final GatingValidator validator = new GatingValidator();
        if (validator.isAllowed(expression, feature, attributes)) {
            System.out.println("User is eligible for this feature : " + feature);
        } else {
            System.out.println("Sorry ! User isn't eligible for this feature : " + feature);
        }
    }

    // And Test Cases

    @Test
    public void evaluateAndOperatorTest1() throws Exception {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("age", 25);
        attributes.put("name", "arshu");

        String feature = "Age and Name Feature";
        String expression = "age == 25 and name == arshu";

        final GatingValidator validator = new GatingValidator();
        if (validator.isAllowed(expression, feature, attributes)) {
            System.out.println("User is eligible for this feature : " + feature);
        } else {
            System.out.println("Sorry ! User isn't eligible for this feature : " + feature);
        }
    }

    @Test
    public void evaluateAndOperatorTest2() throws Exception {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("age", 25);
        attributes.put("name", "ganesh");

        String feature = "Age and Name Feature";
        String expression = "age == 25 and name == arshu";

        final GatingValidator validator = new GatingValidator();
        if (validator.isAllowed(expression, feature, attributes)) {
            System.out.println("User is eligible for this feature : " + feature);
        } else {
            System.out.println("Sorry ! User isn't eligible for this feature : " + feature);
        }
    }

    // Between Operator Test cases

    @Test
    public void evaluateBetweenOperatorTest1() throws Exception {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("age", 25);

        String feature = "Age Between Feature";
        String expression = "age between 20 30";

        final GatingValidator validator = new GatingValidator();
        if (validator.isAllowed(expression, feature, attributes)) {
            System.out.println("User is eligible for this feature : " + feature);
        } else {
            System.out.println("Sorry ! User isn't eligible for this feature : " + feature);
        }
    }


    @Test
    public void evaluateBetweenOperatorTest2() throws Exception {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("age", 25);

        String feature = "Age Between Feature";
        String expression = "age between 30 40";

        final GatingValidator validator = new GatingValidator();
        if (validator.isAllowed(expression, feature, attributes)) {
            System.out.println("User is eligible for this feature : " + feature);
        } else {
            System.out.println("Sorry ! User isn't eligible for this feature : " + feature);
        }
    }

    // GreaterThan operator

    @Test
    public void evaluateGreaterThanOperatorTest1() throws Exception {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("age", 25);

        String feature = "Age Greater than Feature";
        String expression = "age > 20";

        final GatingValidator validator = new GatingValidator();
        if (validator.isAllowed(expression, feature, attributes)) {
            System.out.println("User is eligible for this feature : " + feature);
        } else {
            System.out.println("Sorry ! User isn't eligible for this feature : " + feature);
        }
    }

    @Test
    public void evaluateGreaterThanOperatorTest2() throws Exception {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("age", 25);

        String feature = "Age Greater than Feature";
        String expression = "age > 30";

        final GatingValidator validator = new GatingValidator();
        if (validator.isAllowed(expression, feature, attributes)) {
            System.out.println("User is eligible for this feature : " + feature);
        } else {
            System.out.println("Sorry ! User isn't eligible for this feature : " + feature);
        }
    }

    // GreaterThanEqualsTo


    @Test
    public void evaluateGreaterThanEqualsToOperatorTest1() throws Exception {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("age", 25);

        String feature = "Age Greater than EqualsTo Feature";
        String expression = "age >= 25";

        final GatingValidator validator = new GatingValidator();
        if (validator.isAllowed(expression, feature, attributes)) {
            System.out.println("User is eligible for this feature : " + feature);
        } else {
            System.out.println("Sorry ! User isn't eligible for this feature : " + feature);
        }
    }

    @Test
    public void evaluateGreaterThanEqualsToOperatorTest2() throws Exception {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("age", 25);

        String feature = "Age Greater than EqualsTo Feature";
        String expression = "age >= 30";

        final GatingValidator validator = new GatingValidator();
        if (validator.isAllowed(expression, feature, attributes)) {
            System.out.println("User is eligible for this feature : " + feature);
        } else {
            System.out.println("Sorry ! User isn't eligible for this feature : " + feature);
        }
    }

    // LessThan


    @Test
    public void evaluateLessThanOperatorTest1() throws Exception {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("age", 25);

        String feature = "Age Less than Feature";
        String expression = "age < 30";

        final GatingValidator validator = new GatingValidator();
        if (validator.isAllowed(expression, feature, attributes)) {
            System.out.println("User is eligible for this feature : " + feature);
        } else {
            System.out.println("Sorry ! User isn't eligible for this feature : " + feature);
        }
    }

    @Test
    public void evaluateLessThanOperatorTest2() throws Exception {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("age", 25);

        String feature = "Age Less than Feature";
        String expression = "age < 20";

        final GatingValidator validator = new GatingValidator();
        if (validator.isAllowed(expression, feature, attributes)) {
            System.out.println("User is eligible for this feature : " + feature);
        } else {
            System.out.println("Sorry ! User isn't eligible for this feature : " + feature);
        }
    }

    // LessThanEqualsTo


    @Test
    public void evaluateLessThanEqualsToOperatorTest1() throws Exception {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("age", 25);

        String feature = "Age Less than EqualsTo Feature";
        String expression = "age <= 25";

        final GatingValidator validator = new GatingValidator();
        if (validator.isAllowed(expression, feature, attributes)) {
            System.out.println("User is eligible for this feature : " + feature);
        } else {
            System.out.println("Sorry ! User isn't eligible for this feature : " + feature);
        }
    }

    @Test
    public void evaluateLessThanEqualsToOperatorTest2() throws Exception {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("age", 25);

        String feature = "Age Less than EqualsTo Feature";
        String expression = "age <= 20";

        final GatingValidator validator = new GatingValidator();
        if (validator.isAllowed(expression, feature, attributes)) {
            System.out.println("User is eligible for this feature : " + feature);
        } else {
            System.out.println("Sorry ! User isn't eligible for this feature : " + feature);
        }
    }

    /** Not Equals To Test **/


    @Test
    public void evaluteNotEqualsToBooleanTest1() throws Exception {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("qualify", false);

        String feature = "Qualify Feature";
        String expression = "qualify != true";

        final GatingValidator validator = new GatingValidator();
        if (validator.isAllowed(expression, feature, attributes)) {
            System.out.println("User is eligible for this feature : " + feature);
        } else {
            System.out.println("Sorry ! User isn't eligible for this feature : " + feature);
        }
    }

    @Test
    public void evaluteNotEqualsToBooleanTest2() throws Exception {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("qualify", true);

        String feature = "Qualify Feature";
        String expression = "qualify != true";

        final GatingValidator validator = new GatingValidator();
        if (validator.isAllowed(expression, feature, attributes)) {
            System.out.println("User is eligible for this feature : " + feature);
        } else {
            System.out.println("Sorry ! User isn't eligible for this feature : " + feature);
        }
    }

    @Test
    public void evaluteNotEqualsToStringTest1() throws Exception {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("name", "arshu");

        String feature = "Not Name Feature";
        String expression = "name != ganesh";

        final GatingValidator validator = new GatingValidator();
        if (validator.isAllowed(expression, feature, attributes)) {
            System.out.println("User is eligible for this feature : " + feature);
        } else {
            System.out.println("Sorry ! User isn't eligible for this feature : " + feature);
        }
    }

    @Test
    public void evaluteNotEqualsToStringTest2() throws Exception {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("name", "ganesh");

        String feature = "Not Name Feature";
        String expression = "name != ganesh";

        final GatingValidator validator = new GatingValidator();
        if (validator.isAllowed(expression, feature, attributes)) {
            System.out.println("User is eligible for this feature : " + feature);
        } else {
            System.out.println("Sorry ! User isn't eligible for this feature : " + feature);
        }
    }


    @Test
    public void evaluteNotEqualsToIntegerTest1() throws Exception {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("age", 26);

        String feature = "Age Feature";
        String expression = "age != 25";

        final GatingValidator validator = new GatingValidator();
        if (validator.isAllowed(expression, feature, attributes)) {
            System.out.println("User is eligible for this feature : " + feature);
        } else {
            System.out.println("Sorry ! User isn't eligible for this feature : " + feature);
        }
    }

    @Test
    public void evaluteNotEqualsToIntegerTest2() throws Exception {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("age", 25);

        String feature = "Age Feature";
        String expression = "age != 25";

        final GatingValidator validator = new GatingValidator();
        if (validator.isAllowed(expression, feature, attributes)) {
            System.out.println("User is eligible for this feature : " + feature);
        } else {
            System.out.println("Sorry ! User isn't eligible for this feature : " + feature);
        }
    }

    // Allof test cases

    @Test
    public void evaluteAllOffTest1() throws Exception {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("visitedLocations", "mumbai,gujrat,delhi");

        String feature = "All Of User eligible if they visited these places Feature";
        String expression = "visitedLocations allof delhi,gujrat,bangalore,indore,mumbai";

        final GatingValidator validator = new GatingValidator();
        if (validator.isAllowed(expression, feature, attributes)) {
            System.out.println("User is eligible for this feature : " + feature);
        } else {
            System.out.println("Sorry ! User isn't eligible for this feature : " + feature);
        }
    }

    @Test
    public void evaluteAllOffTest2() throws Exception {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("visitedLocations", "mumbai,gujrat,delhi");

        String feature = "All Of User eligible if they visited these places Feature";
        String expression = "visitedLocations allof delhi,gujrat,bangalore,indore";

        final GatingValidator validator = new GatingValidator();
        if (validator.isAllowed(expression, feature, attributes)) {
            System.out.println("User is eligible for this feature : " + feature);
        } else {
            System.out.println("Sorry ! User isn't eligible for this feature : " + feature);
        }
    }

    // Noneof test cases

    @Test
    public void evaluteNoneOfTest1() throws Exception {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("visitedLocations", "mumbai,delhi");

        String feature = "None Of User eligible if they visited these places Feature";
        String expression = "visitedLocations noneof gujrat,bangalore,indore";

        final GatingValidator validator = new GatingValidator();
        if (validator.isAllowed(expression, feature, attributes)) {
            System.out.println("User is eligible for this feature : " + feature);
        } else {
            System.out.println("Sorry ! User isn't eligible for this feature : " + feature);
        }
    }

    @Test
    public void evaluteNoneOfTest2() throws Exception {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("visitedLocations", "mumbai,gujrat,delhi");

        String feature = "None Of User eligible if they visited these places Feature";
        String expression = "visitedLocations noneof gujrat,bangalore,indore";

        final GatingValidator validator = new GatingValidator();
        if (validator.isAllowed(expression, feature, attributes)) {
            System.out.println("User is eligible for this feature : " + feature);
        } else {
            System.out.println("Sorry ! User isn't eligible for this feature : " + feature);
        }
    }




}
