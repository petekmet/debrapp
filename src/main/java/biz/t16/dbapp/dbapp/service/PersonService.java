package biz.t16.dbapp.dbapp.service;

import biz.t16.dbapp.dbapp.controller.api.Person;

import java.util.List;

public interface PersonService {
    List<Person> getPersons();
    Person getPersonById(String id);
    void createPerson(Person person);
}
