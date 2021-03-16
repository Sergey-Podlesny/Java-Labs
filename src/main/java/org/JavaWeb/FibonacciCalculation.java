package org.JavaWeb;
import org.apache.log4j.Logger;

public class FibonacciCalculation {

    private static final Logger log = Logger.getLogger(FibonacciCalculation.class);

    public static int CalculateFibonacci(int num) throws NotFoundException, ServerError {
        log.debug("Start of FibonacciCalculating method");
        if(num <= 0)
        {
            log.error("num <= 0");
            throw new NotFoundException("Num less then 1");
        }
        if(num > 200)
        {
            log.error("num > 200");
            throw new ServerError("Num more then 200");
        }
        if(num == 1)
        {
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

