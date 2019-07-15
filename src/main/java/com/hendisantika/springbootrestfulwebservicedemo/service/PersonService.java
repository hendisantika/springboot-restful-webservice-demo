package com.hendisantika.springbootrestfulwebservicedemo.service;

import com.hendisantika.springbootrestfulwebservicedemo.model.Person;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-restful-webservice-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-07-16
 * Time: 05:52
 */
public interface PersonService {

    List<Person> getAllPerson();

    Optional<Person> getPersonById(long id);

    Person savePerson(Person person);

    void removePerson(Person person);

}