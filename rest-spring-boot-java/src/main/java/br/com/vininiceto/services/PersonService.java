package br.com.vininiceto.services;

import br.com.vininiceto.Repository.PersonRepository;
import br.com.vininiceto.controller.PersonController;
import br.com.vininiceto.data.dto.v1.PersonInternalDTO;
import br.com.vininiceto.data.dto.v1.PersonPublicDTO;
import br.com.vininiceto.data.dto.v2.PersonDTOV2;
import br.com.vininiceto.exception.ResourceNotFoundException;
import br.com.vininiceto.mapper.BeanMapper;
import br.com.vininiceto.mapper.custom.PersonMapper;
import br.com.vininiceto.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    public
    PersonRepository repository;
    @Autowired
    PersonMapper convert;


    public Logger logger = LoggerFactory.getLogger(PersonService.class.getName());


    public PersonPublicDTO findById(Long id) {

        logger.info("Iniciando busca de usuário");


        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        var dto = BeanMapper.parseObject(entity, PersonPublicDTO.class);
        //dto.add(linkTo(methodOn(PersonController.class).findPersonById(dto.getId())).withRel("findById").withType("GET"));
        addHateoasLinks(dto);

        return dto;
    }

    private PersonPublicDTO addHateoasLinks(PersonPublicDTO dto) {
        dto.add(linkTo(methodOn(PersonController.class).findPersonById(dto.getId())).withRel("findById").withType("GET"));
        dto.add(linkTo(methodOn(PersonController.class).findAllPersons()).withRel("findAll").withType("GET"));
        dto.add(linkTo(methodOn(PersonController.class).createPerson(dto)).withRel("createUser").withType("POST"));
        dto.add(linkTo(methodOn(PersonController.class).deletePerson(dto.getId())).withRel("deleteUser").withType("DELETE"));
        dto.add(linkTo(methodOn(PersonController.class).updatePerson(dto)).withRel("updateUser").withType("PUT"));

        return dto;
    }

    public PersonInternalDTO findByIdTeste(Long id) {

        logger.info("Iniciando busca de usuário");


        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        var dto = BeanMapper.parseObject(entity, PersonInternalDTO.class);
        dto.add(linkTo(methodOn(PersonController.class).findPersonByIdTeste(id)).withSelfRel());
        return dto;
    }

    public List<PersonPublicDTO> findAllPersons() {

        logger.info("Iniciando busca de todos usuários");
        var persons = BeanMapper.parseListObject(repository.findAll(), PersonPublicDTO.class);
        persons.forEach(this::addHateoasLinks);
        return persons;

    }

    public List<PersonDTOV2> findAllPersonsV2() {

        logger.info("Iniciando busca de todos usuários");

        return BeanMapper.parseListObject(repository.findAll(), PersonDTOV2.class);

    }


    public PersonPublicDTO createPerson(PersonPublicDTO person) {

        logger.info("Iniciando criação de usuário");

        var entity = BeanMapper.parseObject(person, Person.class);


        var dto = BeanMapper.parseObject(repository.save(entity), PersonPublicDTO.class);
         addHateoasLinks(dto);
        return dto;
    }


    public PersonDTOV2 createPersonV2(PersonDTOV2 person) {

        logger.info("Iniciando criação de usuário V2");

        var entity = convert.convertEntitytoDTO(person);

        return convert.convertEntityToDTO(repository.saveAndFlush(entity));

    }


    public void deletePerson(Long id) {

        logger.info("Deletando usuário");


        Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        repository.delete(entity);

    }

    public PersonPublicDTO updatePerson(PersonPublicDTO person) {

        logger.info("Iniciando o update de Usuário");
        Person entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        if (repository.existsById(entity.getId())) {


            entity.setFirstName(person.getFirstName());
            entity.setLastName(person.getLastName());
            entity.setAddress(person.getAddress());
            entity.setGender(person.getGender());

        }
        var dto = BeanMapper.parseObject(repository.saveAndFlush(entity), PersonPublicDTO.class);
         addHateoasLinks(dto);
        return dto;
    }


}









