package org.JavaWeb;

import org.junit.Assert;
import org.junit.Test;


public class FibonacciCalculationTest {

    private FibonacciCalculation fibonacciCalculation = new FibonacciCalculation(4);

    @Test
    public void CorrectTest() throws InputException {
        int resultNum = fibonacciCalculation.FibonacciCalculating();
        Assert.assertEquals(2, resultNum);
    }

    @Test
    public void IncorrectTest() throws InputException {
        int resultNum = fibonacciCalculation.FibonacciCalculating();
        Assert.assertNotEquals(1, resultNum);
    }
}