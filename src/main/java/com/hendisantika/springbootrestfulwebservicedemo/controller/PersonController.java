package com.hendisantika.springbootrestfulwebservicedemo.controller;

import com.hendisantika.springbootrestfulwebservicedemo.exception.response.CustomException;
import com.hendisantika.springbootrestfulwebservicedemo.model.Person;
import com.hendisantika.springbootrestfulwebservicedemo.response.Response;
import com.hendisantika.springbootrestfulwebservicedemo.service.PersonService;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("persons/{id}")
    public ResponseEntity<Person> getPersonById(
            @ApiParam(value = "Id of person", required = true) @PathVariable("id") long id) throws CustomException {
        Person person = personService.getPersonById(id).get();
        if (person == null) {
            throw new CustomException("Person with provided id:" + id + " not found");
        }
        return new ResponseEntity<Person>(person, HttpStatus.OK);
    }

    @DeleteMapping("persons/{id}")
    public ResponseEntity<Response> removePersonById(
            @ApiParam(value = "Id of person to be deleted", required = true) @PathVariable("id") long id)
            throws CustomException {
        Person person = personService.getPersonById(id).get();
        if (person == null) {
            throw new CustomException("Person with provided id:" + id + " cannot be deleted");
        }
        personService.removePerson(person);
        logger.info("Person deleted successfully");
        Response response = new Response(HttpStatus.OK.value(), "Person has been deleted");
        return new ResponseEntity<Response>(response, HttpStatus.NO_CONTENT);
    }

}
