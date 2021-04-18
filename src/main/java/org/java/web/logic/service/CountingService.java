package org.java.web.logic.service;

import org.java.web.logic.calculator.Counter;
import org.springframework.stereotype.Component;


@Component
public class CountingService implements Service<Integer, Counter<Integer>> {

    @Override
    public Integer doService(Counter<Integer> entity) {
        entity.increment();
        return entity.getCount();
    }
}
