package org.java.web;

import org.apache.log4j.Logger;
import org.java.web.logic.calculator.FibonacciCalculation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {

    private static final Logger log = Logger.getLogger(Application.class);

    public static void main(String[] args) {

        log.debug("Start of Main");
        SpringApplication.run(Application.class, args);
        log.debug("End of Main");
    }
}
