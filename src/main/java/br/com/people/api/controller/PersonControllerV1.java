package br.com.people.api.controller;

import br.com.people.api.db.DataBase;
import br.com.people.api.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/v1/people")
@Slf4j
public class PersonControllerV1 {

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
    public ResponseEntity<Person> get(@PathVariable long id) {

        var person = dataBase.find(id);
        if (person != null) {
            log.info("The id of person is {}", id);
            return ResponseEntity.ok(person);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        log.info("The id {} was successfully deleted", id);
        dataBase.deleteById(id);
        return ResponseEntity.ok("OK");
    }


    @PutMapping
    public ResponseEntity<Person> update(@RequestBody Person person) {
        log.info("The person {} was successfully updated", person);
        dataBase.update(person);
        return ResponseEntity.ok(person);
    }


}
