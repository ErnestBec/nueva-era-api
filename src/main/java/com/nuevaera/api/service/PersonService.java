package com.nuevaera.api.service;

import com.nuevaera.api.dto.PersonDTO;
import com.nuevaera.api.model.Person;
import com.nuevaera.api.repository.PersonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final ModelMapper modelMapper;

    public PersonService(ModelMapper modelMapper, PersonRepository personRepository) {
        this.modelMapper = modelMapper;
        this.personRepository = personRepository;
    }

    //save
    public PersonDTO save(PersonDTO personDTO){
        Person person = modelMapper.map(personDTO, Person.class);
        return  modelMapper.map(personRepository.save(person), PersonDTO.class);
    }
}
