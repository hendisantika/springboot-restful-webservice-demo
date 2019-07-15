package com.hendisantika.springbootrestfulwebservicedemo.model.reference;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-restful-webservice-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-07-16
 * Time: 05:48
 */
@Component
@ConfigurationProperties(prefix = "errors")
public class ErrorReference {
    private Map<String, String> description = new HashMap<>();

    public Map<String, String> getDescription() {
        return description;
    }

    public void setDescription(Map<String, String> description) {
        this.description = description;
    }

    public String getDescription(String errorCode) {
        return this.description.get(errorCode);
    }

}