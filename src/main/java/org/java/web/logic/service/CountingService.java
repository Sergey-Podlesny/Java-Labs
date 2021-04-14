package org.java.web.logic.service;

import org.java.web.logic.calculator.Counter;
import org.java.web.logic.calculator.RequestCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CountingService implements Service<Integer, Counter<Integer>> {

    @Autowired
    RequestCounter requestCounter;

    @Override
    public Integer doService(Counter<Integer> entity) {
        int requestNum = requestCounter.count(entity);
        return requestNum;
    }
}
