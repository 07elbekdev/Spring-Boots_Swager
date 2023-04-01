package it.springboot.service;

import it.springboot.dto.request.PersonRequest;
import it.springboot.exception.MyUniversalException;
import it.springboot.model.Person;
import it.springboot.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public List<Person> getPeople() {
        return personRepository.findAll();
    }

    public void register(PersonRequest newPerson) {
        Person person = new Person();
        person.setName(newPerson.getName());
        person.setAge(newPerson.getAge());
        personRepository.save(person);
    }

    public Person getById(Long id) {
        Optional<Person> person = Optional.ofNullable(personRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Person with id " + id + " doesn't exist")));
        Person ps = new Person();
        ps.setId(person.get().getId());
        ps.setName(person.get().getName());
        ps.setAge(person.get().getAge());
        return ps;
    }

    public void deleteById(Long id) {
        boolean exist = personRepository.existsById(id);
        if (!exist) {
            throw new MyUniversalException("Person with id " + id + " doesn't exist");
        }
        personRepository.deleteById(id);
    }
}