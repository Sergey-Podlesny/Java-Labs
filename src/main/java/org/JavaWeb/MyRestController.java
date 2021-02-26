package org.JavaWeb;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("task")
public class MyRestController {
    @GetMapping
    public String speedCounting(@RequestParam int m1, @RequestParam int m2, @RequestParam int v1, @RequestParam int v2) throws InputException {
        double v3;
        SpeedCounter obj = new SpeedCounter(m1, m2, v1, v2);
        v3 = obj.SpeedCounting();
        return String.format("v3 = %f",v3);
    }
}