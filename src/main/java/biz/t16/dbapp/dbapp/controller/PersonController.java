package biz.t16.dbapp.dbapp.controller;

import biz.t16.dbapp.dbapp.controller.api.Person;
import biz.t16.dbapp.dbapp.service.NotFoundException;
import biz.t16.dbapp.dbapp.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    private PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping
    List<Person> getPersons() {
        return service.getPersons();
    }

    @GetMapping("/{id}")
    Person getPersonById(@PathVariable String id) {
        try {
            return service.getPersonById(id);
        } catch(NotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

    @PostMapping
    void createPerson(@RequestBody Person person) {
        service.createPerson(person);
    }
}
