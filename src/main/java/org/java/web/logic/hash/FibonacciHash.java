package org.java.web.logic.hash;

import org.java.web.entity.ResultDto;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class FibonacciHash {

    private final Map<Integer, ResultDto> map = new HashMap<>();

    public boolean isAlreadyHashed(Integer num) {
        return map.containsKey(num);
    }

    public void addToMao(Integer num, ResultDto dto) {
        map.put(num, dto);
    }

    public ResultDto getParameters(Integer num) {
        return map.get(num);
    }
}
