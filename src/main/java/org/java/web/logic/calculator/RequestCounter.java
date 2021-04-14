package org.java.web.logic.calculator;

import org.springframework.stereotype.Component;

@Component
public class RequestCounter {
    public Integer count(Counter<Integer> entity) {
        synchronized (this) {
            entity.increment();
            return entity.getCount();
        }
    }
}
