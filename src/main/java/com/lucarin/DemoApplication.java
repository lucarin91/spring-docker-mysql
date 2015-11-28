package com.lucarin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {
    @Autowired
    private PersonRepository repository;

    @RequestMapping("/")
    public String home() {
        Person n = new Person();
        n.setFirstName("DIO");
        n.setLastName("eDai");

        this.repository.save(n);

        String ris="";
        for(Person p : this.repository.findAll()){
            ris+=p.getName()+"</br>";
        };
        return ris;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DemoApplication.class, args);
    }
}
