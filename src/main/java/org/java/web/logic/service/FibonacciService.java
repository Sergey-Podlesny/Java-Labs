package org.java.web.logic.service;

import org.apache.log4j.Logger;
import org.java.web.data.File;
import org.java.web.entity.NumDto;
import org.java.web.entity.ResultDto;
import org.java.web.exception.BadRequestException;
import org.java.web.exception.ServerErrorException;
import org.java.web.logic.calculator.Counter;
import org.java.web.logic.calculator.FibonacciCalculation;
import org.java.web.logic.calculator.RequestCounter;
import org.java.web.logic.calculator.ResultsHandler;
import org.java.web.logic.hash.FibonacciCache;
import org.java.web.logic.validator.InputValidator;
import org.java.web.logic.validator.ServerValidator;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@org.springframework.stereotype.Service
public class FibonacciService implements Service<ResultDto, Stream<Integer>> {
    @Autowired
    private FibonacciCache cache;
    @Autowired
    private ResultDto resultDto;
    @Autowired
    private FibonacciCalculation fibonacciCalculation;
    @Autowired
    private RequestCounter requestCounter;
    @Autowired
    ResultsHandler resultsHandler;
    @Autowired
    private Service<Integer, Counter<Integer>> counterService;
    @Autowired
    private File file;
    private static final Logger log = Logger.getLogger(FibonacciService.class);
    private List<Integer> resultNumList = new ArrayList<>();

    @Override
    public ResultDto doService(Stream<Integer> stream) throws BadRequestException, ServerErrorException, IOException {
        int requestNum = counterService.doService(requestCounter);
        int num = stream.collect(Collectors.toList()).get(0);
        checkValid(num);
        int resultNum = getResultNum(num);
        resultNumList.add(resultNum);
        resultsHandler.processingResultNumList(resultDto, resultNumList);
        resultDto.setRequestNum(requestNum);
        resultDto.setResultNum(resultNum);
        file.write("file.txt", resultDto.toString());
        return resultDto;
    }


    private int getResultNum(Integer num) throws BadRequestException, ServerErrorException {
        int resultNum;
        if (cache.isAlreadyHashed(num)) {
            resultNum = cache.getParameters(num).getNum();
        } else {
            resultNum = fibonacciCalculation.calculateFibonacci(num);
            NumDto numDto = new NumDto(resultNum);
            cache.addToMap(num, numDto);
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
