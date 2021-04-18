package org.java.web.controllers;
import org.apache.log4j.Logger;
import org.java.web.entity.NumDto;
import org.java.web.exception.BadRequestException;
import org.java.web.entity.ResultDto;
import org.java.web.exception.ServerErrorException;
import org.java.web.logic.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping("task")
public class MyRestController {

    private static final Logger log = Logger.getLogger(MyRestController.class);

    @Autowired
    private Service<ResultDto, Stream<Integer>> service;

    @GetMapping
    public ResultDto calculating(@RequestParam int num) throws BadRequestException, ServerErrorException {
        log.info("Get Request param from URL");
        ResultDto resultDto = service.doService(Stream.of(num));

        log.info("Return task answer");
        return resultDto;
    }

    @PostMapping
    public ResultDto calculating(@RequestBody NumDto numDto) throws BadRequestException, ServerErrorException {
        ResultDto resultDto = service.doService(Stream.of(numDto.getNum()));
        return resultDto;
    }
}