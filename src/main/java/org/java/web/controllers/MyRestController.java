package org.java.web.controllers;
import org.apache.log4j.Logger;
import org.java.web.logic.calculator.FibonacciCalculation;
import org.java.web.exception.BadRequestException;
import org.java.web.entity.ResultDto;
import org.java.web.exception.ServerErrorException;
import org.java.web.logic.services.FibonacciService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("task")
public class MyRestController {

    private static final Logger log = Logger.getLogger(FibonacciCalculation.class);

    @GetMapping
    public ResultDto Calculating(@RequestParam int num) throws BadRequestException, ServerErrorException {
        log.info("Get Request param from URL");
        ResultDto dto = new FibonacciService().doService(num);
        log.info("Return task answer");
        return dto;
    }
}