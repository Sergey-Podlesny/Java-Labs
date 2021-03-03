package org.JavaWeb;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("task")
public class MyRestController {

    private static final Logger log = Logger.getLogger(FibonacciCalculation.class);

    @GetMapping
    public String Calculating(@RequestParam int num) throws InputException {
        log.info("Get Request param from URL");
        FibonacciCalculation obj = new FibonacciCalculation(num);
        int resultNum = obj.FibonacciCalculating();
        log.info("Return task answer");
        return String.format("resultNum = %d",resultNum);
    }
}