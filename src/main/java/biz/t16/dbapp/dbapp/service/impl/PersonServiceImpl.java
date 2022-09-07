package biz.t16.dbapp.dbapp.service.impl;

import biz.t16.dbapp.dbapp.controller.api.Person;
import biz.t16.dbapp.dbapp.model.repository.impl.MemoryPersonRepository;
import biz.t16.dbapp.dbapp.service.NotFoundException;
import biz.t16.dbapp.dbapp.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    private MemoryPersonRepository repository;

    public PersonServiceImpl(MemoryPersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Person> getPersons() {
        return repository.findAll();
    }

    @Override
    public Person getPersonById(String id) throws NotFoundException {
        return repository.findById(id);
    }

    @Override
    public void createPerson(Person person) {
        repository.save(person);
    }
}
