package org.JavaWeb;

import org.junit.Assert;
import org.junit.Test;


public class FibonacciCalculationTest {

    @Test
    public void CorrectTest() throws NotFoundException, ServerError {
        int resultNum = FibonacciCalculation.CalculateFibonacci(4);
        Assert.assertEquals(2, resultNum);
    }

    @Test
    public void IncorrectTest() throws NotFoundException, ServerError {
        int resultNum = FibonacciCalculation.CalculateFibonacci(4);
        Assert.assertNotEquals(1, resultNum);
    }
}