package org.java.web.logic.calculator;
import org.apache.log4j.Logger;
import org.java.web.exception.BadRequestException;
import org.java.web.exception.ServerErrorException;
import org.springframework.stereotype.Component;

@Component
public class FibonacciCalculation {

    private static final Logger log = Logger.getLogger(FibonacciCalculation.class);

    public int calculateFibonacci(int num) throws BadRequestException, ServerErrorException {
        log.debug("Start of FibonacciCalculating method");
        if(num == 1) {
            return 0;
        }
        int[] arr = new int[num];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < num; ++i) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[arr.length - 1];
    }
}

