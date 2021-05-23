package org.java.web.logic.cache;

import org.java.web.entity.NumDto;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class FibonacciCache {

    private final Map<Integer, NumDto> map = new HashMap<>();

    public boolean isAlreadyHashed(Integer num) {
        return map.containsKey(num);
    }

    public void addToMap(Integer num, NumDto dto) {
        map.put(num, dto);
    }

    public NumDto getParameters(Integer num) {
        return map.get(num);
    }
}
