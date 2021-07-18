package com.stupzz.trainingbook.Exceptions.NotFound;

import com.stupzz.trainingbook.Exceptions.ServerError;
import org.springframework.http.HttpStatus;

public abstract class NotFoundException extends ServerError {
    public NotFoundException() {
        super();
    }
    @Override
    public void handleException(){
        httpStatus = HttpStatus.NOT_FOUND;
    }
}
