package org.JavaWeb;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("task")
public class MyRestController {

    private static final Logger log = Logger.getLogger(SpeedCounter.class);

    @GetMapping
    public String speedCounting(@RequestParam int m1, @RequestParam int m2, @RequestParam int v1, @RequestParam int v2) throws InputException {
        log.info("Get Request param from URL");
        double v3;
        SpeedCounter obj = new SpeedCounter(m1, m2, v1, v2);
        v3 = obj.SpeedCounting();
        log.info("Return task answer");
        return String.format("v3 = %f",v3);
    }
}