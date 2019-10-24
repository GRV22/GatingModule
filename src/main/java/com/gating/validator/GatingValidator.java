package com.gating.validator;

import java.util.Map;

public interface GatingValidator {
    boolean isAllowed(String conditionalExperssion, String featureName, Map<String, Object> attributes) throws
            Exception;
}
