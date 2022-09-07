package biz.t16.dbapp.dbapp;

import biz.t16.dbapp.dbapp.controller.api.Person;
import biz.t16.dbapp.dbapp.model.repository.impl.MemoryPersonRepository;
import biz.t16.dbapp.dbapp.service.NotFoundException;
import biz.t16.dbapp.dbapp.service.PersonService;
import biz.t16.dbapp.dbapp.service.impl.PersonServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

public class PersonServiceTest {
    private final MemoryPersonRepository repository = mock(MemoryPersonRepository.class);
    private final PersonService service = new PersonServiceImpl(repository);

    @BeforeEach
    void setUp() {
        Person p = new Person();
        p.setId("1");
        p.setName("John Doe");
        when(repository.findById("2")).thenThrow(new NotFoundException());
        when(repository.findById("1")).thenReturn(p);
        when(repository.save(any())).thenReturn(p);
        when(repository.findAll()).thenReturn(List.of(p));
    }

    @Test
    void testPersonCreated() {
        // given
        Person p = new Person();
        p.setId("3");
        p.setName("Frank Zappa");
        // when
        service.createPerson(p);
        // then
        verify(repository, times(1)).save(eq(p));
        verifyNoMoreInteractions(repository);
    }

    @Test
    void testUnknownPersonQueried() {
        // when
        try {
            service.getPersonById("2");
            fail();
        } catch (Exception ex) {
            // then
            assertTrue(ex instanceof NotFoundException);
        }
    }

    @Test
    void testKnownPersonQueried() {
        // when
        Person p = service.getPersonById("1");
        // then
        assertThat(p.getName()).isEqualTo(p.getName());
    }

    @Test
    void testWhenAllPersonsRequestdThenArrayRetruned() {
        // when
        List<Person> allPersons = service.getPersons();
        assertThat(allPersons.size()).isEqualTo(1);
    }
}
