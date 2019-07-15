package com.hendisantika.springbootrestfulwebservicedemo.exception.response;

import com.hendisantika.springbootrestfulwebservicedemo.exception.ModelError;
import com.hendisantika.springbootrestfulwebservicedemo.exception.ValidationErrorResponse;
import com.hendisantika.springbootrestfulwebservicedemo.model.reference.ErrorReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-restful-webservice-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-07-16
 * Time: 05:57
 */
@ControllerAdvice
public class RootExceptionHandler {

    @Autowired
    private MessageSourceAccessor messageSourceAccessor;

    @Autowired
    private ErrorReference errorReference;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handleErrors(MethodArgumentNotValidException exception) {
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        ValidationErrorResponse errResponse = new ValidationErrorResponse();
        errResponse.setErrorCode(422);
        errResponse.setErrorType("Validation Error");
        errResponse.setMessage(errorReference.getDescription().get("EXC400"));
        fieldErrors.forEach(fieldError -> {
            ModelError error = new ModelError(fieldError.getField(), messageSourceAccessor.getMessage(fieldError));
            errResponse.addError(error);
        });
        return new ResponseEntity<ValidationErrorResponse>(errResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ExceptionErrorResponse> customExceptionHandler(CustomException ex) {
        ExceptionErrorResponse error = new ExceptionErrorResponse();
        error.setErrorCode(HttpStatus.NOT_FOUND.value());
        error.setMessage(ex.getErrorMessage());
        return new ResponseEntity<ExceptionErrorResponse>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionErrorResponse> exceptionHandler(Exception ex) {
        ExceptionErrorResponse error = new ExceptionErrorResponse();
        error.setErrorCode(HttpStatus.BAD_REQUEST.value());
        error.setMessage("BAD request");
        return new ResponseEntity<ExceptionErrorResponse>(error, HttpStatus.BAD_REQUEST);
    }

}