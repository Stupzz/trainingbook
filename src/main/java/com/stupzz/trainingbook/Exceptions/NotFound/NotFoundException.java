package com.stupzz.trainingbook.Exceptions.NotFound;

import com.stupzz.trainingbook.Exceptions.ServerError;
import org.springframework.http.HttpStatus;

public class NotFoundException extends ServerError {
    public NotFoundException(String message) {
        super(message);
    }
    @Override
    public void handleException(){
        httpStatus = HttpStatus.NOT_FOUND;
    }
}
