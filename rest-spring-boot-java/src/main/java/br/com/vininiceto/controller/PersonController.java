package br.com.vininiceto.controller;

import br.com.vininiceto.Repository.PersonRepository;
import br.com.vininiceto.data.dto.v1.PersonInternalDTO;
import br.com.vininiceto.data.dto.v1.PersonPublicDTO;
import br.com.vininiceto.data.dto.v2.PersonDTOV2;
import br.com.vininiceto.services.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/persons/v1")
@Tag(name = "Persons", description = "EndPoints to Managing People")
public class PersonController {

    @Autowired
    private PersonService service;

    @Autowired
    private PersonRepository repository;

    @Operation(summary = "Find a persons", description = "EndPoint to find a specific persons", tags = {"Persons"},
            responses = {@ApiResponse(description = "Success", responseCode = "200", content = {
                    @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = PersonPublicDTO.class)),
                    @Content(
                            mediaType = MediaType.APPLICATION_XML_VALUE, schema = @Schema(implementation = PersonPublicDTO.class))}
            ),
                    @ApiResponse(description = "No content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)})
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/hal+json"})
    public PersonPublicDTO findPersonById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @Operation(summary = "Find a persons", description = "EndPoint to find a specific persons", tags = {"Persons"},
            responses = {@ApiResponse(description = "Success", responseCode = "200", content = {
                    @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = PersonPublicDTO.class)),
                    @Content(
                            mediaType = MediaType.APPLICATION_XML_VALUE, schema = @Schema(implementation = PersonPublicDTO.class))}
            ),
                    @ApiResponse(description = "No content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)})
    @GetMapping(value = "/teste/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/hal+json"})
    public PersonInternalDTO findPersonByIdTeste(@PathVariable Long id) {
        var person = service.findByIdTeste(id);
        person.setSensitiveData("Foo bar");
        return person;

    }

    @Operation(summary = "Find All persons", description = "EndPoint to find all persons", tags = {"Persons"},
            responses = {@ApiResponse(description = "Success", responseCode = "201", content = {
                    @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = PersonPublicDTO.class))),
                    @Content(
                            mediaType = MediaType.APPLICATION_XML_VALUE, array = @ArraySchema(schema = @Schema(implementation = PersonPublicDTO.class)))}
            ),
                    @ApiResponse(description = "No content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content)})
    @GetMapping("/users")
    public ResponseEntity<List<PersonPublicDTO>> findAllPersons() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllPersons());
    }

    @Operation(summary = "Find All persons", description = "EndPoint to find all persons", tags = {"Persons"},
            responses = {@ApiResponse(description = "Success", responseCode = "201", content = {
                    @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = PersonPublicDTO.class))),
                    @Content(
                            mediaType = MediaType.APPLICATION_XML_VALUE, array = @ArraySchema(schema = @Schema(implementation = PersonPublicDTO.class)))}
            ),
                    @ApiResponse(description = "No content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content)})
    @GetMapping(value = "/v2/users", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<PersonDTOV2>> findAllPersonsV2() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllPersonsV2());
    }


    @Operation(summary = "Create person", description = "EndPoint to create person", tags = {"Persons"},
            responses = {@ApiResponse(description = "Success", responseCode = "201", content = {
                    @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = PersonPublicDTO.class)),
                    @Content(
                            mediaType = MediaType.APPLICATION_XML_VALUE, schema = @Schema(implementation = PersonPublicDTO.class))}
            ),
                    @ApiResponse(description = "No content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content)})
    @PostMapping("/register")
    public ResponseEntity<PersonPublicDTO> createPerson(@RequestBody PersonPublicDTO person) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createPerson(person));
    }

    @Operation(summary = "Create person", description = "EndPoint to create person", tags = {"Persons"},
            responses = {@ApiResponse(description = "Success", responseCode = "201", content = {
                    @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = PersonPublicDTO.class)),
                    @Content(
                            mediaType = MediaType.APPLICATION_XML_VALUE, schema = @Schema(implementation = PersonPublicDTO.class))}
            ),
                    @ApiResponse(description = "No content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content)})
    @PostMapping("/v2/register")
    public ResponseEntity<PersonDTOV2> createPersonV2(@RequestBody PersonDTOV2 person) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createPersonV2(person));
    }


    @Operation(summary = "Update person", description = "EndPoint to update person", tags = {"Persons"},
            responses = {@ApiResponse(description = "Success", responseCode = "200", content = {
                    @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = PersonPublicDTO.class)),
                    @Content(
                            mediaType = MediaType.APPLICATION_XML_VALUE, schema = @Schema(implementation = PersonPublicDTO.class))}
            ),
                    @ApiResponse(description = "No content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content)})
    @PutMapping("/update")
    public ResponseEntity<PersonPublicDTO> updatePerson(@RequestBody PersonPublicDTO person) {
        return ResponseEntity.status(HttpStatus.OK).body(service.updatePerson(person));
    }

    @Operation(summary = "Delete person", description = "EndPoint to delete person", tags = {"Persons"},
            responses = {@ApiResponse(description = "Success", responseCode = "200", content = {
                    @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = PersonPublicDTO.class)),
                    @Content(
                            mediaType = MediaType.APPLICATION_XML_VALUE, schema = @Schema(implementation = PersonPublicDTO.class))}
            ),
                    @ApiResponse(description = "No content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content)})
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePerson(@PathVariable("id") Long id) {
        service.deletePerson(id);
        return ResponseEntity.status(HttpStatus.OK).body("User deleted!");
    }


}
