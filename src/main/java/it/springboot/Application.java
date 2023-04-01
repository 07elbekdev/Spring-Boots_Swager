package it.springboot;

import lombok.RequiredArgsConstructor;
import it.springboot.model.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import it.springboot.repositories.PersonRepository;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
@RestController
@RequiredArgsConstructor
public class Application {
    private final PersonRepository personRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void init() {
        personRepository.saveAll(List.of(
                new Person("Todd", 16),
                new Person("John", 17),
                new Person("Alex", 18),
                new Person("Daniel", 19),
                new Person("Marlen", 29)
        ));
    }
}