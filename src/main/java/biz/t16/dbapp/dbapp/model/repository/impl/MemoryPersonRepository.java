package biz.t16.dbapp.dbapp.model.repository.impl;

import biz.t16.dbapp.dbapp.controller.api.Person;
import biz.t16.dbapp.dbapp.model.repository.Repository;
import biz.t16.dbapp.dbapp.service.NotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@Component
public class MemoryPersonRepository implements Repository<Person, String> {
    private Map<String, Person> storage = new Hashtable<>();
    @Override
    public Person save(Person person) {
        storage.put(person.getId(), person);
        return person;
    }

    @Override
    public Person findById(String id) {
        Person person = storage.get(id);
        if(person == null) throw new NotFoundException("Item "+id+" not found");
        return person;
    }

    @Override
    public List<Person> findAll() {
        return new ArrayList<>(storage.values());
    }
}
