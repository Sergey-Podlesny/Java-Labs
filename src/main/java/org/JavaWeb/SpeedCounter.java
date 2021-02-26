package org.JavaWeb;

public class SpeedCounter {
    private int m1;
    private int m2;
    private int v1;
    private int v2;
    private double v3;

    public SpeedCounter(int m1, int m2, int v1, int v2) {
        this.m1 = m1;
        this.m2 = m2;
        this.v1 = v1;
        this.v2 = v2;
    }

    public Double SpeedCounting() throws InputException {
        if(m1 == 0 || m2 == 0)
        {
            throw new InputException("error");
        }
        return (double) (m1 * v1 + m2 * v2) / (m1 + m2);
    }
}

