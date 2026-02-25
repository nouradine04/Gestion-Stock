package com.nouradine.springgestion.handlers;

import com.nouradine.springgestion.exception.EntityNotFoundException;
import com.nouradine.springgestion.exception.InvalidEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDto> handleException(EntityNotFoundException exception){
        final HttpStatus notfound=HttpStatus.NOT_FOUND;
        final ErrorDto errorDto= ErrorDto.builder()
                .codes(exception.getErrorCodes())
                .httpCode(notfound.value())
                .messsage(exception.getMessage())
                .build();
        return new ResponseEntity<>(errorDto,notfound);
    }

    @ExceptionHandler(InvalidEntityException.class)
    public ResponseEntity<ErrorDto> handleException(EntityNotFoundException exception, WebRequest webRequest){
        final HttpStatus badRequest=HttpStatus.BAD_REQUEST;
        final  ErrorDto errorDto= ErrorDto.builder()
                .codes(exception.getErrorCodes())
                .httpCode(badRequest.value())
                .build();
        return new ResponseEntity<>(errorDto,badRequest);
    }
}
