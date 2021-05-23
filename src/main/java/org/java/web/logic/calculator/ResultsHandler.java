package org.java.web.logic.calculator;

import org.java.web.entity.ResultDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.OptionalDouble;

@Component
public class ResultsHandler {
    public void processingResultNumList(ResultDto resultDto, List<Integer> resultNumList) {

        int minNumResult = resultNumList.stream().min(Integer::compare).get();
        int maxNumResult = resultNumList.stream().max(Integer::compareTo).get();
        OptionalDouble averNumResult = resultNumList.stream().mapToInt(Integer::intValue).average();

        resultDto.setMinResultNum(minNumResult);
        resultDto.setMaxResultNum(maxNumResult);
        resultDto.setAverResultNum(averNumResult);

    }
}
