package biz.t16.dbapp.dbapp;

import biz.t16.dbapp.dbapp.controller.api.Person;
import biz.t16.dbapp.dbapp.model.repository.impl.MemoryPersonRepository;
import biz.t16.dbapp.dbapp.service.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MemoryPersonRepositoryTest {
    @Test
    void testWhenUnknownIDRequestedThenNotFoundException() {
        MemoryPersonRepository repository = new MemoryPersonRepository();
        Assertions.assertThrows(NotFoundException.class, () -> repository.findById("1"));
    }

    @Test
    void testWhenSpecificIdRequestedThenCorrectEntryFound() {
        Person p1 = new Person();
        p1.setId("1");
        p1.setName("John Doe");
        Person p2 = new Person();
        p2.setId("2");
        p2.setName("Frank Green");
        MemoryPersonRepository repository = new MemoryPersonRepository();
        repository.save(p1);
        repository.save(p2);
        // when
        Person retrieved = repository.findById("1");
        // then
        assertEquals(retrieved, p1);
    }
}
