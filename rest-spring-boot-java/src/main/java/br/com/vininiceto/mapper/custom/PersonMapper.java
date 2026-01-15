package br.com.vininiceto.mapper.custom;

import br.com.vininiceto.data.dto.v2.PersonDTOV2;
import br.com.vininiceto.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonDTOV2 convertEntityToDTO(Person person) {

        PersonDTOV2 entity = new PersonDTOV2();
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        entity.setBirthDay(new Date());

        return entity;


    }

    public Person convertEntitytoDTO(PersonDTOV2 person) {

        Person entity = new Person();
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return entity;


    }


}
