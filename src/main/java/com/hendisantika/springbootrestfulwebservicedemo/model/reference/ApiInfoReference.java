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
 * Time: 05:47
 */
@Component
@ConfigurationProperties(prefix = "api")
public class ApiInfoReference {
    private Map<String, String> info = new HashMap<>();

    public Map<String, String> getInfo() {
        return this.info;
    }

    public void setInfo(Map<String, String> info) {
        this.info = info;
    }

    public String getInfo(String key) {
        return this.info.get(key);
    }
}