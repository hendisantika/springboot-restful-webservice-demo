package com.hendisantika.springbootrestfulwebservicedemo.mock;

import com.hendisantika.springbootrestfulwebservicedemo.model.Address;
import com.hendisantika.springbootrestfulwebservicedemo.model.Person;
import com.hendisantika.springbootrestfulwebservicedemo.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-restful-webservice-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-07-16
 * Time: 06:21
 */
@Configuration
public class UserMockData {
    private static final Logger logger = LoggerFactory.getLogger(UserMockData.class);

    /*
     * When you want to execute some piece of code exactly before the
     * application startup completes, We can use it
     */
    @Bean
    public CommandLineRunner setUp(PersonRepository personRepository) {
        return (args) -> {
            personRepository.save(new Person("Uzumaki Naruto", "Software Developer",
                    new Address("MeadowCreek Drive", "1110", "Irving Texas", "12345")));
            personRepository
                    .save(new Person("Hatake Kakashi", "Lawyer", new Address("Dallas Drive", "1269", "Dallas Texas", "78569")));
            personRepository.save(
                    new Person("Jack the Reaper", "DBA", new Address("Washington PKWY", "8914", "Maclean Virgina ", "89567")));
            personRepository.save(new Person("Uchiha Sasuke", " Software Tester",
                    new Address("Jonh F Carpenter Street", "1550", "Las-Colinas Texas", "10256")));
            logger.info("Sample Data Generated");
        };

    }
}