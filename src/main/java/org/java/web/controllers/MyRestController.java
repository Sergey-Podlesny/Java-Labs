package org.java.web.controllers;

import org.apache.log4j.Logger;
import org.java.web.entity.NumDto;
import org.java.web.entity.ResultDto;
import org.java.web.exception.BadRequestException;
import org.java.web.exception.ServerErrorException;
import org.java.web.logic.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Stream;

@RestController
@RequestMapping("task")
public class MyRestController {

    private static final Logger log = Logger.getLogger(MyRestController.class);

    @Autowired
    private Service<ResultDto, Stream<Integer>> service;

    @GetMapping
    public ResultDto calculating(@RequestParam int num) throws BadRequestException, ServerErrorException, IOException {
        log.info("Get Request param from URL");
        ResultDto resultDto = service.doService(Stream.of(num));
        log.info("Return task answer");
        return resultDto;
    }

    @PostMapping
    public ArrayList<ResultDto> calculating(@RequestBody ArrayList<NumDto> numDtoList) throws BadRequestException, ServerErrorException, IOException {
        ArrayList<ResultDto> resultDtoList = new ArrayList<>();
        for(int i = 0; i < numDtoList.size(); i++)
        {
            resultDtoList.add(service.doService(Stream.of(numDtoList.get(i).getNum())));
        }
        return resultDtoList;
    }
}