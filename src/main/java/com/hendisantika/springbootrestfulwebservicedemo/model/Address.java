package com.hendisantika.springbootrestfulwebservicedemo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-restful-webservice-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-07-16
 * Time: 05:45
 */
@Entity
@Data
public class Address {
    @Id
    @GeneratedValue
    private long id;
    private String street;
    private String aptNo;
    private String cityState;
    private String zip;

    public Address(String street, String aptNo, String cityState, String zip) {
        this.street = street;
        this.aptNo = aptNo;
        this.cityState = cityState;
        this.zip = zip;
    }
}
