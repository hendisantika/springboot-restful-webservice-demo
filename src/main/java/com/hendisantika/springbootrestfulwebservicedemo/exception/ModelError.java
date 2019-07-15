package com.hendisantika.springbootrestfulwebservicedemo.exception;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-restful-webservice-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-07-16
 * Time: 05:55
 */
@Data
public class ModelError {
    private String message;
    private String errorField;
}
