package biz.t16.dbapp.dbapp.model.repository;

import biz.t16.dbapp.dbapp.controller.api.Person;

import java.util.List;

public interface Repository<A, B> {
    A save(A person);
    Person findById(B id);
    List<Person> findAll();
}
