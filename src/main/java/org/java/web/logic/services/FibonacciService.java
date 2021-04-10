package org.java.web.logic.services;

import org.apache.log4j.Logger;
import org.java.web.entity.ResultDto;
import org.java.web.exception.BadRequestException;
import org.java.web.exception.ServerErrorException;
import org.java.web.logic.calculator.FibonacciCalculation;
import org.java.web.logic.validator.InputValidator;
import org.java.web.logic.validator.ServerValidator;


public class FibonacciService implements Service<ResultDto, Integer> {

    private static final Logger log = Logger.getLogger(FibonacciService.class);

    @Override
    public ResultDto doService(Integer num) throws BadRequestException, ServerErrorException {
        if (!(new InputValidator().isValidInput(num))) {
            log.error("num <= 0");
            throw new BadRequestException("Num less then 1");
        }
        if(!(new ServerValidator().isValidForServer(num)))
        {
            log.error("num > 200");
            throw new ServerErrorException("Num more then 200");
        }
        int result = new FibonacciCalculation().CalculateFibonacci(num);
        return new ResultDto(result);
    }

}
