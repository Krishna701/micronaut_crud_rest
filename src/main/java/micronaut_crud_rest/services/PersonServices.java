package micronaut_crud_rest.services;

import micronaut_crud_rest.Entity.Person;
import micronaut_crud_rest.dto.PersonDTO;
import micronaut_crud_rest.repository.PersonRepository;

import java.util.List;
import java.util.UUID;

public interface PersonServices {
    PersonDTO  createPerson(PersonDTO personDTO);

    PersonDTO findById(UUID id);

    List<PersonDTO> getAllUsers();

//    List<PersonDTO> findById();

    List<PersonDTO> getByName(String name);

    List<PersonDTO> getByAge(String age);

//    PersonDTO findByName(String name);

//    boolean deleteById(String id);


    boolean deleteById(UUID id);

    PersonDTO updateName(UUID id, PersonDTO personDTO);
}
