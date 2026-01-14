package br.com.vininiceto.controller;

import br.com.vininiceto.Repository.PersonRepository;
import br.com.vininiceto.data.dto.v1.PersonInternalDTO;
import br.com.vininiceto.data.dto.v1.PersonPublicDTO;
import br.com.vininiceto.data.dto.v2.PersonDTOV2;
import br.com.vininiceto.model.Person;
import br.com.vininiceto.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;


@RestController
@RequestMapping("/api/persons/v1")
public class PersonController {

    @Autowired
    private PersonService service;

    @Autowired
    private PersonRepository repository;

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/hal+json"})
    public PersonPublicDTO findPersonById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @GetMapping(value = "/teste/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/hal+json"})
    public PersonInternalDTO findPersonByIdTeste(@PathVariable Long id) {
        var person = service.findByIdTeste(id);
        person.setSensitiveData("Foo bar");
        return person;

    }


    @GetMapping("/users")
    public ResponseEntity<List<PersonPublicDTO>> findAllPersons() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllPersons());
    }

    @GetMapping("/v2/users")
    public ResponseEntity<List<PersonDTOV2>> findAllPersonsV2() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllPersonsV2());
    }


    @PostMapping("/register")
    public ResponseEntity<PersonPublicDTO> createPerson(@RequestBody PersonPublicDTO person) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createPerson(person));
    }

    @PostMapping("/v2/register")
    public ResponseEntity<PersonDTOV2> createPersonV2(@RequestBody PersonDTOV2 person) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createPersonV2(person));
    }


    @PutMapping("/update")
    public ResponseEntity<PersonPublicDTO> updatePerson(@RequestBody PersonPublicDTO person) {
        return ResponseEntity.status(HttpStatus.OK).body(service.updatePerson(person));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePerson(@PathVariable("id") Long id) {
        service.deletePerson(id);
        return ResponseEntity.status(HttpStatus.OK).body("User deleted!");
    }


}
