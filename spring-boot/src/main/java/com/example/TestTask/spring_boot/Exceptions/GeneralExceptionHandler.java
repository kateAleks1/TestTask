package com.example.TestTask.spring_boot.Exceptions;

import com.example.TestTask.spring_boot.entity.ErrorResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GeneralExceptionHandler {

    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<ErrorResponseDto> handleGeneralException(GeneralException exception) {

        ErrorResponseDto errorResponse = new ErrorResponseDto(exception.getHttpStatus().value(), exception.getMessage());
        log.info("From GeneralExceptionHandler::handleGeneralException. Send message error ({})", exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.OK);
    }
}
