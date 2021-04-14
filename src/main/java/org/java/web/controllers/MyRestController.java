package org.java.web.controllers;
import org.apache.log4j.Logger;
import org.java.web.exception.BadRequestException;
import org.java.web.entity.ResultDto;
import org.java.web.exception.ServerErrorException;
import org.java.web.logic.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("task")
public class MyRestController {

    private static final Logger log = Logger.getLogger(MyRestController.class);

    @Autowired
    private Service<ResultDto, Integer> service;

    @GetMapping
    public ResultDto calculating(@RequestParam int num) throws BadRequestException, ServerErrorException {
        log.info("Get Request param from URL");
        ResultDto resultDto = service.doService(num);

        log.info("Return task answer");
        return resultDto;
    }
}