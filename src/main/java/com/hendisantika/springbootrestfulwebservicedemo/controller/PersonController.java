package com.hendisantika.springbootrestfulwebservicedemo.controller;

import com.hendisantika.springbootrestfulwebservicedemo.model.Person;
import com.hendisantika.springbootrestfulwebservicedemo.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-restful-webservice-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-07-16
 * Time: 06:23
 */
@RestController
@RequestMapping(value = "/api/")
public class PersonController {
    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonService personService;

    @GetMapping
    public String getHome() {
        return "My name is Uzumaki Naruto";
    }

    @GetMapping("persons")
    public ResponseEntity<List<Person>> getAllPersons() {
        logger.info("All persons listed");
        List<Person> persons = personService.getAllPerson();
        return new ResponseEntity<List<Person>>(persons, HttpStatus.OK);
    }

}
