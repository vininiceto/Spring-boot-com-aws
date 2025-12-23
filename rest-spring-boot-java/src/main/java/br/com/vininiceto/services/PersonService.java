package br.com.vininiceto.services;

import br.com.vininiceto.Repository.PersonRepository;
import br.com.vininiceto.data.dto.v1.PersonDTO;
import br.com.vininiceto.data.dto.v2.PersonDTOV2;
import br.com.vininiceto.exception.ResourceNotFoundException;
import br.com.vininiceto.mapper.ObjectMapper;
import br.com.vininiceto.mapper.custom.PersonMapper;
import br.com.vininiceto.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository repository;
    @Autowired
    PersonMapper convert;


    private Logger logger = LoggerFactory.getLogger(PersonService.class.getName());


    public PersonDTO findById(Long id) {

        logger.info("Iniciando busca de usuário");

        return ObjectMapper.parseObject(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID")), PersonDTO.class);
    }

    public List<PersonDTO> findAllPersons() {

        logger.info("Iniciando busca de todos usuários");

        return ObjectMapper.parseListObject(repository.findAll(), PersonDTO.class);

    }

    public List<PersonDTOV2> findAllPersonsV2() {

        logger.info("Iniciando busca de todos usuários");

        return ObjectMapper.parseListObject(repository.findAll(), PersonDTOV2.class);

    }





    public PersonDTO createPerson(PersonDTO person) {

        logger.info("Iniciando criação de usuário");

       var entity = ObjectMapper.parseObject(person, Person.class);


        return ObjectMapper.parseObject(repository.save(entity), PersonDTO.class);
    }


    public PersonDTOV2 createPersonV2(PersonDTOV2 person){

        logger.info("Iniciando criação de usuário V2");

        var entity = convert.convertEntitytoDTO(person);

        return convert.convertEntityToDTO(repository.saveAndFlush(entity));

    }




    public void deletePerson(Long  id) {

        logger.info("Deletando usuário");


        Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));

        repository.delete(entity);

    }

    public PersonDTO updatePerson(Person person) {

        logger.info("Iniciando o update de Usuário");
        Person entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        if (repository.existsById(entity.getId())) {


            entity.setFirstName(person.getFirstName());
            entity.setLastName(person.getLastName());
            entity.setAdress(person.getAdress());
            entity.setGender(person.getGender());

        }
        return ObjectMapper.parseObject(repository.saveAndFlush(entity), PersonDTO.class);

    }


}









