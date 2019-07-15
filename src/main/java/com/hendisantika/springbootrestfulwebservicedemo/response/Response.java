package com.hendisantika.springbootrestfulwebservicedemo.response;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-restful-webservice-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-07-16
 * Time: 05:52
 */
@Component
@Data
public class Response {
    private int value;
    private String message;


    public Response() {
    }

    public Response(int value, String message) {
        super();
        this.value = value;
        this.message = message;

    }
}
