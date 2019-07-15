package com.hendisantika.springbootrestfulwebservicedemo.exception;

import com.hendisantika.springbootrestfulwebservicedemo.exception.response.ExceptionErrorResponse;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-restful-webservice-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-07-16
 * Time: 05:55
 */
@Component
@Data
public class ValidationErrorResponse extends ExceptionErrorResponse {
    private String errorType;
    private List<ModelError> errors;

    public ValidationErrorResponse() {
        errors = new ArrayList<>();
    }

}
