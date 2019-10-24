package com.gating.testcases.functional.handler;

import com.gating.operators.handler.TernaryOperatorTypeHandler;
import com.gating.operators.handler.between.BetweenDoubleHandler;
import com.gating.operators.handler.between.BetweenIntegerHandler;
import com.gating.operators.handler.between.BetweenStringHandler;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BetweenHandlerTest {

    private TernaryOperatorTypeHandler startHandler;

    @BeforeTest
    public void setUp() {
        startHandler = new BetweenIntegerHandler(new BetweenDoubleHandler(new BetweenStringHandler(null)));
    }

    @Test
    public void testString() {
        System.out.println(startHandler.apply("d", "a", "f"));
    }

}
