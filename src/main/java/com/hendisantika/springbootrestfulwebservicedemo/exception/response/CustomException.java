package com.hendisantika.springbootrestfulwebservicedemo.exception.response;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-restful-webservice-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-07-16
 * Time: 05:59
 */
//When controller throws CustomException it first call this class and then only @ControllerAdvice is called
public class CustomException extends Exception {
    private static final long serialVersionUID = 1L;
    private String errorMessage;

    public CustomException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}