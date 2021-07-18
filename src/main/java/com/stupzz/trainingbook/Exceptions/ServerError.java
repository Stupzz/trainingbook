package com.stupzz.trainingbook.Exceptions;

import com.stupzz.trainingbook.domains.HttpExceptionData;
import org.springframework.http.HttpStatus;

public abstract class ServerError extends RuntimeException{
    protected String msg;
    protected HttpStatus httpStatus;

    public ServerError() {
        super();
    }

    public abstract void handleException();

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMsg() {
        return msg;
    }
}
