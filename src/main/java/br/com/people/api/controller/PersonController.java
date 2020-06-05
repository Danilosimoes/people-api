package br.com.people.api.controller;

import br.com.people.api.db.DataBase;
import br.com.people.api.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
@Slf4j
public class PersonController {

    // Sprint Rest https://mkyong.com/spring-boot/spring-rest-hello-world-example/https://mkyong.com/spring-boot/spring-rest-hello-world-example/

    @Autowired
    private DataBase dataBase;

    @PostMapping
    public ResponseEntity<String> post(@RequestBody Person person) {
        log.info("Person is => {}", person);
        dataBase.insert(person);
        return ResponseEntity.ok("OK");
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Person> get(@PathVariable long id){
        log.info("The id of person is {}", id);
        var person = dataBase.find(id);
        return ResponseEntity.ok(person);
    }

    // TODO: delete
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Person> deleteById(@PathVariable long id) {
        log.info("The id {} was successfully deleted", id);
        dataBase.deleteById(id);
        return ResponseEntity.ok(long id);
    }

    @PutMapping
    public ResponseEntity<Person> Update(@PathVariable Person person) {
        log.info("The id {} was successfully updated", person);
        var person = dataBase.find(person);
        return ResponseEntity.ok(person);
    }





    // ADD update method
    // ADD delete method
}
