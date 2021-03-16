package org.JavaWeb;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("task")
public class MyRestController {

    private static final Logger log = Logger.getLogger(FibonacciCalculation.class);

    @GetMapping
    public ResultDto Calculating(@RequestParam int num) throws NotFoundException, ServerError {
        log.info("Get Request param from URL");
        int resultNum = FibonacciCalculation.CalculateFibonacci(num);
        ResultDto obj = new ResultDto(resultNum);
        log.info("Return task answer");
        return obj;
    }
}