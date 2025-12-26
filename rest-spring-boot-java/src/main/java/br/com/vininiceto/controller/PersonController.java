package br.com.vininiceto.controller;

import br.com.vininiceto.Repository.PersonRepository;
import br.com.vininiceto.data.dto.v1.PersonDTO;
import br.com.vininiceto.data.dto.v2.PersonDTOV2;
import br.com.vininiceto.model.Person;
import br.com.vininiceto.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/persons/v1")
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

    @GetMapping("/v2/users")
    public ResponseEntity<List<PersonDTOV2>> findAllPersonsV2() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllPersonsV2());
    }


    @PostMapping("/register")
    public ResponseEntity<PersonDTO> createPerson(@RequestBody PersonDTO person) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createPerson(person));
    }

    @PostMapping("/v2/register")
    public ResponseEntity<PersonDTOV2> createPersonV2(@RequestBody PersonDTOV2 person){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createPersonV2(person));
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
