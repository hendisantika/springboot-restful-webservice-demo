package com.hendisantika.springbootrestfulwebservicedemo.exception.response;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-restful-webservice-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-07-16
 * Time: 05:56
 */
@Component
@Data
public class ExceptionErrorResponse {

    private int errorCode;
    private String message;
}
