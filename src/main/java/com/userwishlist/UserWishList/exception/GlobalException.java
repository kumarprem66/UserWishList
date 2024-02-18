package com.userwishlist.UserWishList.exception;


import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<MyError> handleValidationException(ValidationException ex,WebRequest wr) {
        MyError me = new MyError();
        me.setLocalDateTime(LocalDateTime.now());
        me.setMessage(ex.getMessage());
        me.setDetails(wr.getDescription(false));
        return new ResponseEntity<>(me, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MyError> methodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest wr){
        MyError me = new MyError();
        me.setLocalDateTime(LocalDateTime.now());
        me.setMessage(ex.getMessage());
        me.setDetails(wr.getDescription(false));
        return new ResponseEntity<>(me, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> commonException(Exception e){

        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<MyError> noHandlerFound(NoHandlerFoundException ex,WebRequest wr){
        MyError me = new MyError();
        me.setLocalDateTime(LocalDateTime.now());
        me.setMessage(ex.getMessage());
        me.setDetails(wr.getDescription(false));
        return new ResponseEntity<>(me, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(CustomerExistException.class)
    public ResponseEntity<MyError> customerException(CustomerExistException ex,WebRequest wr){
        MyError me = new MyError();
        me.setLocalDateTime(LocalDateTime.now());
        me.setMessage(ex.getMessage());
        me.setDetails(wr.getDescription(false));
        return new ResponseEntity<>(me, HttpStatus.NOT_ACCEPTABLE);


    }

    @ExceptionHandler(WishListException.class)
    public ResponseEntity<MyError> wishListException(WishListException ex,WebRequest wr){
        MyError me = new MyError();
        me.setLocalDateTime(LocalDateTime.now());
        me.setMessage(ex.getMessage());
        me.setDetails(wr.getDescription(false));
        return new ResponseEntity<>(me, HttpStatus.NOT_ACCEPTABLE);

    }

    @ExceptionHandler(AuthorizationServiceException.class)
    public ResponseEntity<MyError> authorizationException(AuthorizationServiceException ex,WebRequest wr){
        MyError me = new MyError();
        me.setLocalDateTime(LocalDateTime.now());
        me.setMessage(ex.getMessage());
        me.setDetails(wr.getDescription(false));
        return new ResponseEntity<>(me, HttpStatus.FORBIDDEN);

    }




}
