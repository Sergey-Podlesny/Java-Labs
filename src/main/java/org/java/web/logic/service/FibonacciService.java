package org.java.web.logic.service;

import org.apache.log4j.Logger;
import org.java.web.entity.NumDto;
import org.java.web.entity.ResultDto;
import org.java.web.exception.BadRequestException;
import org.java.web.exception.ServerErrorException;
import org.java.web.logic.calculator.Counter;
import org.java.web.logic.calculator.FibonacciCalculation;
import org.java.web.logic.calculator.RequestCounter;
import org.java.web.logic.hash.FibonacciHash;
import org.java.web.logic.validator.InputValidator;
import org.java.web.logic.validator.ServerValidator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@org.springframework.stereotype.Service
public class FibonacciService implements Service<ResultDto, Stream<Integer>> {

    @Autowired
    private FibonacciHash hash;
    @Autowired
    private ResultDto resultDto;
    @Autowired
    private FibonacciCalculation fibonacciCalculation;
    @Autowired
    private RequestCounter requestCounter;
    @Autowired
    private Service<Integer, Counter<Integer>> counterService;
    private static final Logger log = Logger.getLogger(FibonacciService.class);
    private List<Integer> resultNumList = new ArrayList<>();

    @Override
    public ResultDto doService(Stream<Integer> stream) throws BadRequestException, ServerErrorException {
        int requestNum = counterService.doService(requestCounter);
        int num = stream.collect(Collectors.toList()).get(0);
        checkValid(num);
        int resultNum = getResultNum(num);
        resultNumList.add(resultNum);
        processingResultNumList();
        resultDto.setRequestNum(requestNum);
        resultDto.setResultNum(resultNum);
        return resultDto;
    }

    private void processingResultNumList() {

        int minNumResult = resultNumList.stream().min(Integer::compareTo).get();
        int maxNumResult = resultNumList.stream().max(Integer::compareTo).get();
        OptionalDouble averNumResult = resultNumList.stream().mapToInt(Integer::intValue).average();

        resultDto.setMinResultNum(minNumResult);
        resultDto.setMaxResultNum(maxNumResult);
        resultDto.setAverResultNum(averNumResult);

    }


    private int getResultNum(Integer num) throws BadRequestException, ServerErrorException {
        int resultNum;
        if (hash.isAlreadyHashed(num)) {
            resultNum = hash.getParameters(num).getNum();
        } else {
            resultNum = fibonacciCalculation.calculateFibonacci(num);
            NumDto numDto = new NumDto(resultNum);
            hash.addToMap(num, numDto);
        }
        return resultNum;
    }


    private void checkValid(Integer num) throws BadRequestException, ServerErrorException {
        if (!(new InputValidator().isValidInput(num))) {
            log.error("num <= 0");
            throw new BadRequestException("Num less then 1");
        }
        if (!(new ServerValidator().isValidForServer(num))) {
            log.error("num > 200");
            throw new ServerErrorException("Num more then 200");
        }
    }

}
