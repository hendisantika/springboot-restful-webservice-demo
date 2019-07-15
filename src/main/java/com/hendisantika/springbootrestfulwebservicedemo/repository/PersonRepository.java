package com.hendisantika.springbootrestfulwebservicedemo.repository;

import com.hendisantika.springbootrestfulwebservicedemo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-restful-webservice-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-07-16
 * Time: 05:51
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
