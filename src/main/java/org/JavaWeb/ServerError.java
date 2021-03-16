package org.JavaWeb;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Illegal arguments")
public class ServerError extends Exception {
    public ServerError(String message) {
        super(message);
    }

    public ServerError(String message, Throwable cause) {
        super(message, cause);
    }

    public ServerError(Throwable cause) {
        super(cause);
    }

    public ServerError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
