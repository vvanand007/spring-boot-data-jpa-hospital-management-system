package com.codingshuttle.youtube.hospitalManagement.errror;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ApiError {
    private String error;
    private HttpStatus httpStatus;
    private LocalDateTime localDateTime;

    public ApiError(String error, HttpStatus httpStatus) {
        this.error = error;
        this.httpStatus = httpStatus;
        this.localDateTime = LocalDateTime.now();
    }
}
