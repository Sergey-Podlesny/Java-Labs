package org.java.web.entity;

import org.java.web.logic.calculator.Counter;
import org.springframework.stereotype.Component;

@Component
public class CountDto implements Counter<Integer> {
    private int count;

    public CountDto() {
        count = 0;
    }

    @Override
    public void increment() {
        count++;
    }

    @Override
    public void decrement() {
        count--;
    }

    @Override
    public Integer getCount() {
        return count;
    }

}
