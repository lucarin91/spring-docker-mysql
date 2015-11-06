package com.lucarin;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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

@Repository
interface PersonRepository extends CrudRepository<Person, Long> {

}

@Entity
class Person {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    public Long getId(){
            return id;
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }
}
