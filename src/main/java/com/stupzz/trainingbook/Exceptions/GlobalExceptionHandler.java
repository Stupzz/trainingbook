package com.stupzz.trainingbook.Exceptions;

import com.stupzz.trainingbook.Exceptions.NotFound.ExerciseNotFound;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ServerError.class})
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        ((ServerError) ex).handleException();
        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), ((ServerError) ex).getHttpStatus(), request);
    }
}


