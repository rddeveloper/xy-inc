package com.zup.apitestedesenvolvedor3.exception;

import com.zup.apitestedesenvolvedor3.exception.response.Response;
import com.zup.apitestedesenvolvedor3.exception.response.ResponseError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handleMethodBusiness(BusinessException ex, WebRequest request) {
        return buildResponseEntity(new Response(HttpStatus.BAD_REQUEST, ex.getMessage()));
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        Response response = new Response();
        List<ResponseError> responseErrors = new ArrayList<>();
        response.setStatus(status);
        response.setMessage("Error validate field");

        for(FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            responseErrors.add(new ResponseError(fieldError.getObjectName(),
                    fieldError.getField(),fieldError.getRejectedValue(), messageSource.getMessage(fieldError, LocaleContextHolder.getLocale())));
        }

        response.setResponseErrors(responseErrors);

        return buildResponseEntity(response);

    }

    private ResponseEntity<Object> buildResponseEntity(Response response) {
        return new ResponseEntity<>(response, response.getStatus());
    }

}
