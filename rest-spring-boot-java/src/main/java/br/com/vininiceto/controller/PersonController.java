package br.com.vininiceto.controller;

import br.com.vininiceto.Repository.PersonRepository;
import br.com.vininiceto.data.dto.PersonDTO;
import br.com.vininiceto.model.Person;
import br.com.vininiceto.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService service;

    @Autowired
    private PersonRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> findPersonById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @GetMapping("/users")
    public ResponseEntity<List<PersonDTO>> findAllPersons() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllPersons());
    }


    @PostMapping("/register")
    public ResponseEntity<PersonDTO> createPerson(@RequestBody PersonDTO person) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createPerson(person));
    }

    @PutMapping("/update")
    public ResponseEntity<PersonDTO> updatePerson(@RequestBody Person person) {
        return ResponseEntity.status(HttpStatus.OK).body(service.updatePerson(person));
    }

    @DeleteMapping("/delete")
    public ResponseEntity deletePerson(@PathVariable Long id) {
        service.deletePerson(id);
        return ResponseEntity.status(HttpStatus.OK).body("User deleted!");
    }


}
