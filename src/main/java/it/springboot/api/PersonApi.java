package it.springboot.api;

import it.springboot.dto.request.PersonRequest;
import lombok.RequiredArgsConstructor;
import it.springboot.model.Person;
import org.springframework.web.bind.annotation.*;
import it.springboot.service.PersonService;

import java.util.List;

@RestController("api/v1/person")
@RequiredArgsConstructor
public class PersonApi {
    private final PersonService personService;

    @GetMapping("show/AllPeople")
    public List<Person> getAll() {
        return personService.getPeople();
    }

    @PostMapping("save/Person")
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

    @PutMapping("updateById/{id}")
    public String updateById(@PathVariable Long id, @RequestBody PersonRequest personRequest) {
        personService.updateById(id, personRequest);
        return "Person with id " + id + " successfully updated !!!";
    }

    @GetMapping("search/{keyword}")
    public List<Person> search(@PathVariable String keyword) {
        return personService.searchByName(keyword);
    }
}