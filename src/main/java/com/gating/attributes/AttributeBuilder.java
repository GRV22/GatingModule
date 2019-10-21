package com.gating.attributes;

import com.gating.enums.Attribute;

import java.util.HashMap;
import java.util.Map;

public class AttributeBuilder {

    private Map<String, Object> attributes;

    public AttributeBuilder() {
        attributes = new HashMap<String, Object>();
    }

    public void add(final Attribute attribute, final Object value) {
        attributes.put(attribute.toString(), value);
    }

    public Map<String, Object> getResult() {
        return new HashMap<String, Object>(attributes);
    }

}
