package com.hendisantika.springbootrestfulwebservicedemo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-restful-webservice-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-07-16
 * Time: 05:46
 */

@Entity
@Data
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue
    private long id;

    @NotEmpty
    private String name;
    private String position;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private Address address;

    public Person(String name, String position, Address address) {
        super();
        this.name = name;
        this.position = position;
        this.address = address;
    }
}
