package com.everest.dating.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ErrorResponse {

    private HttpStatus status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyMMdd hh:mm:ss")
    private LocalDateTime timeStamp;

    private String message;

    public ErrorResponse(HttpStatus status) {
        this();
        this.status = status;
    }

    public ErrorResponse(HttpStatus status, String response) {
        this();
        this.status = status;
        this.message = response;
    }

    public ErrorResponse() {
        timeStamp = LocalDateTime.now();
    }

    public ErrorResponse(HttpStatus status, LocalDateTime timestamp, String response) {
        this();
        this.status = status;
        this.timeStamp = timestamp;
        this.message = response;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
