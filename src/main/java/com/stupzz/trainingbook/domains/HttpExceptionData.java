package com.stupzz.trainingbook.domains;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.WebRequest;

import java.net.http.HttpHeaders;

@Data
public class HttpExceptionData {
    private String message;
    private HttpStatus status;
}
