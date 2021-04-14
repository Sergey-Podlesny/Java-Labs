package org.java.web;

import org.java.web.exception.BadRequestException;
import org.java.web.exception.ServerErrorException;
import org.java.web.logic.calculator.FibonacciCalculation;
import org.junit.Assert;
import org.junit.Test;


public class FibonacciCalculationTest {

    @Test
    public void CorrectTest() throws BadRequestException, ServerErrorException {
        int resultNum = new FibonacciCalculation().calculateFibonacci(4);
        Assert.assertEquals(2, resultNum);
    }

    @Test
    public void IncorrectTest() throws BadRequestException, ServerErrorException {
        int resultNum = new FibonacciCalculation().calculateFibonacci(4);
        Assert.assertNotEquals(1, resultNum);
    }
}