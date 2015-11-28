package com.lucarin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class DemoApplication {
    @Autowired
    private PersonRepository repository;

    @RequestMapping(value="/person", method=RequestMethod.GET)
    public Iterable<Person> getPerson() {
        return this.repository.findAll();
    }

    @RequestMapping(value="/person", method=RequestMethod.POST)
    public Person newPerson(@RequestBody final Person person) {
        this.repository.save(person);
        return person;
    }

    @RequestMapping(value="/", method=RequestMethod.GET)
    public String home() {
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DemoApplication.class, args);
    }
}
