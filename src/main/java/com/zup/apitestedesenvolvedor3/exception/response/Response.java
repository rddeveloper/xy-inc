package com.zup.apitestedesenvolvedor3.exception.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private List<ResponseError> responseErrors;

    public Response() {
        this.timestamp = LocalDateTime.now();
    }

    public Response(String message) {
        this();
        this.message = message;
    }

    public Response(HttpStatus status, String message) {
        this();
        this.status = status;
        this.message = message;
    }

    public Response(HttpStatus status, String message, List<ResponseError> responseErrors) {
        this();
        this.status = status;
        this.message = message;
        this.responseErrors = responseErrors;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ResponseError> getResponseErrors() {
        return responseErrors;
    }

    public void setResponseErrors(List<ResponseError> responseErrors) {
        this.responseErrors = responseErrors;
    }
}
