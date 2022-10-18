package micronaut_crud_rest.serviceImplemantation;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import micronaut_crud_rest.Entity.Person;
import micronaut_crud_rest.dto.PersonDTO;
import micronaut_crud_rest.mapper.PersonMapper;
import micronaut_crud_rest.repository.PersonRepository;
import micronaut_crud_rest.services.PersonServices;

import java.util.List;
import java.util.UUID;

@Singleton
public class PersonServiceImplementation implements PersonServices {

    @Inject
    PersonRepository personRepository;
    @Override
    public PersonDTO createPerson(PersonDTO personDTO) {
        Person data = PersonMapper.toEntity(personDTO);
        return PersonMapper.toDto(personRepository.save(data));
    }

    @Override
    public PersonDTO findById(UUID id){
        var c = personRepository.findAll();
        var data = personRepository.findById(id);
        return PersonMapper.toDto(data.get());
    }
    @Override
    public List<PersonDTO> getAllUsers() {
        return PersonMapper.toDtoList(personRepository.findAll());
    }

    @Override
    public List<PersonDTO> getByName(String name) {
        return PersonMapper.toDtoList(personRepository.findByName(name));
    }

  @Override
    public List<PersonDTO> getByAge(String age) {
        return PersonMapper.toDtoList(personRepository.findByAge(age));
    }

    @Override
    public boolean deleteById(UUID id) {
        var data = personRepository.findById(id);
        if(data.isPresent()){
            personRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public PersonDTO updateName(UUID id, PersonDTO existingPerson){
        PersonDTO personDTOnew = existingPerson.toBuilder()
                .name(existingPerson.name())
                .age(existingPerson.age())
                .address(existingPerson.address())
                .institutions(existingPerson.institutions())
                .rollNumber(existingPerson.rollNumber())
                .email(existingPerson.email())
                .build();

        var updatingPerson = PersonMapper.toEntity(personDTOnew);
        var updatedPerson = personRepository.update(updatingPerson);
        return PersonMapper.toDto(updatedPerson);
    }
}
