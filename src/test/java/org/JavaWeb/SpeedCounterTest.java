package org.JavaWeb;

import org.junit.Assert;
import org.junit.Test;


public class SpeedCounterTest {

    private SpeedCounter speedCounter = new SpeedCounter(20, 43, 19, -3);

    @Test
    public void CorrectTest() throws InputException {
        double v3 = speedCounter.SpeedCounting();
        Assert.assertEquals(3.98, v3, 0.01);
    }

    @Test
    public void IncorrectTest() throws InputException {
        double v3 = speedCounter.SpeedCounting();
        Assert.assertNotEquals(13.98, v3, 0.01);
    }
}