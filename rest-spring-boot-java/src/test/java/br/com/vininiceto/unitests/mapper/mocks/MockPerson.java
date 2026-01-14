package br.com.vininiceto.unitests.mapper.mocks;

import br.com.vininiceto.data.dto.v1.PersonInternalDTO;
import br.com.vininiceto.model.Person;

import java.util.ArrayList;
import java.util.List;

public class MockPerson {


    public Person mockEntity() {
        return mockEntity(0);
    }
    
    public PersonInternalDTO mockDTO() {
        return mockDTO(0);
    }
    
    public List<Person> mockEntityList() {
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockEntity(i));
        }
        return persons;
    }

    public List<PersonInternalDTO> mockDTOList() {
        List<PersonInternalDTO> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockDTO(i));
        }
        return persons;
    }
    
    public Person mockEntity(Integer number) {
        Person person = new Person();
        person.setAddress("Address Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setGender(((number % 2)==0) ? "Male" : "Female");
        person.setId(number.longValue());
        person.setLastName("Last Name Test" + number);
        return person;
    }

    public PersonInternalDTO mockDTO(Integer number) {
        PersonInternalDTO person = new PersonInternalDTO();
        person.setAddress("Address Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setGender(((number % 2)==0) ? "Male" : "Female");
        person.setId(number.longValue());
        person.setLastName("Last Name Test" + number);
        return person;
    }

}