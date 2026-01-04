package com.codingshuttle.youtube.hospitalManagement.errror;

import io.jsonwebtoken.JwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;

@RestControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(UsernameNotFoundException.class)
    ResponseEntity<ApiError> usernameNotFoundException(UsernameNotFoundException ex) {
        ApiError apiError = new ApiError("Username not found with username : "+ex.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(apiError, apiError.getHttpStatus());
    }

    @ExceptionHandler(AuthenticationException.class)
    ResponseEntity<ApiError> authenticationException(AuthenticationException ex) {
        ApiError apiError = new ApiError("Authentication failed : "+ex.getMessage(), HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(apiError, apiError.getHttpStatus());
    }

    @ExceptionHandler(JwtException.class)
    ResponseEntity<ApiError> jwtException(JwtException ex) {
        ApiError apiError = new ApiError("Invalid JWT token : "+ex.getMessage(), HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(apiError, apiError.getHttpStatus());
    }

    @ExceptionHandler(AccessDeniedException.class)
    ResponseEntity<ApiError> accessDeniedException(AccessDeniedException ex) {
        ApiError apiError = new ApiError("Access denied, Insufficient permission : "+ex.getMessage(), HttpStatus.FORBIDDEN);
        return new ResponseEntity<>(apiError, apiError.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    ResponseEntity<ApiError> exception(Exception ex) {
        ApiError apiError = new ApiError("Username not found with username : "+ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(apiError, apiError.getHttpStatus());
    }
}
