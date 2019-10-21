package com.gating.enums;

public enum Attribute {
    NAME("name"),
    AGE("age"),
    EMAILID("emailId"),
    ACCOUNTTYPE("accountType"),
    GENDER("gender"),
    ZIPCODE("zipCode"),
    STATE("state"),
    COUNTRY("country");

    private String attributeName;

    Attribute(final String attributeName) {
        this.attributeName = attributeName;
    }

    @Override
    public String toString() {
        return this.attributeName;
    }
}
