package org.java.web.logic.calculator;

import org.springframework.stereotype.Component;

@Component
public class RequestCounter implements Counter<Integer> {

    private Integer counter = 0;

    @Override
    public void increment() {
        synchronized (counter) {
            counter++;
        }
    }

    @Override
    public Integer getCount() {
        return counter;
    }
}
