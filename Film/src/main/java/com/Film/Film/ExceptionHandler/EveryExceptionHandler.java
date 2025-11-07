//package com.Film.Film.ExceptionHandler;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//@ControllerAdvice
//public class EveryExceptionHandler {
//    @ExceptionHandler
//    public ResponseEntity<ErrorResponse> handleException(Exception ex){
//        ErrorResponse error = new ErrorResponse();
//        error.setMessage(ex.getMessage());
//        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
//        error.setTimestamp(System.currentTimeMillis());
//        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//}
