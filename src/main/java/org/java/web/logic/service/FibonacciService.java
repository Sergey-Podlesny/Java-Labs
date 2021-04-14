package org.java.web.logic.service;

import org.apache.log4j.Logger;
import org.java.web.entity.CountDto;
import org.java.web.entity.NumDto;
import org.java.web.entity.ResultDto;
import org.java.web.exception.BadRequestException;
import org.java.web.exception.ServerErrorException;
import org.java.web.logic.calculator.Counter;
import org.java.web.logic.calculator.FibonacciCalculation;
import org.java.web.logic.hash.FibonacciHash;
import org.java.web.logic.validator.InputValidator;
import org.java.web.logic.validator.ServerValidator;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class FibonacciService implements Service<ResultDto, Integer> {

    @Autowired
    private FibonacciHash hash;
    @Autowired
    private CountDto countDto;
    @Autowired
    private ResultDto resultDto;
    @Autowired
    private FibonacciCalculation fibonacciCalculation;
    @Autowired
    private Service<Integer, Counter<Integer>> countingService;
    private static final Logger log = Logger.getLogger(FibonacciService.class);

    @Override
    public ResultDto doService(Integer num) throws BadRequestException, ServerErrorException {
        int requestNum = countingService.doService(countDto);
        if (!(new InputValidator().isValidInput(num))) {
            log.error("num <= 0");
            throw new BadRequestException("Num less then 1");
        }
        if (!(new ServerValidator().isValidForServer(num))) {
            log.error("num > 200");
            throw new ServerErrorException("Num more then 200");
        }
        int resultNum;
        if (hash.isAlreadyHashed(num)) {
            resultNum = hash.getParameters(num).getNum();
        } else {
            resultNum = fibonacciCalculation.calculateFibonacci(num);
            NumDto numDto = new NumDto(resultNum);
            hash.addToMao(num, numDto);
        }
        resultDto.setRequestNum(requestNum);
        resultDto.setResultNum(resultNum);
        return resultDto;
    }
}
