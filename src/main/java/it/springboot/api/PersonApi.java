package it.springboot.api;

import it.springboot.dto.request.PersonRequest;
import lombok.RequiredArgsConstructor;
import it.springboot.model.Person;
import org.springframework.web.bind.annotation.*;
import it.springboot.service.PersonService;

import java.util.List;

@RestController("it/springboot/api/v1/person")//I should to not forget to use this without it/springboot and then see what's gonna happen
@RequiredArgsConstructor
public class PersonApi {
    private final PersonService personService;

    @GetMapping
    public List<Person> getAll() {
        return personService.getPeople();
    }

    @PostMapping
    public String savePerson(@RequestBody PersonRequest request) {
        personService.register(request);
        return "Person with name " + request.getName() + " saved";
    }

    @GetMapping("getById/{id}")
    public Person getById(@PathVariable Long id) {
        return personService.getById(id);
    }

    @DeleteMapping("deleteById/{id}")
    public String deleteById(@PathVariable Long id) {
        personService.deleteById(id);
        return "Person with id " + id + " successfully deleted !!!";
    }
}