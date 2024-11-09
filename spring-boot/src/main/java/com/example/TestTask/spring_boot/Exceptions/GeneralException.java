package com.example.TestTask.spring_boot.Exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class GeneralException extends RuntimeException {
    private HttpStatus httpStatus;

    public GeneralException(String message) {
        super(message);
    }

    public GeneralException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
