package com.stupzz.trainingbook.Exceptions;

import com.stupzz.trainingbook.domains.HttpExceptionData;
import org.springframework.http.HttpStatus;

public abstract class ServerError extends RuntimeException{
    protected HttpStatus httpStatus;

    public ServerError(String message) {
        super(message);
    }

    public abstract void handleException();

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
