package micronaut_crud_rest.mapper;

import lombok.Builder;
import micronaut_crud_rest.Entity.Person;
import micronaut_crud_rest.dto.PersonDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Builder(toBuilder = true)
public class PersonMapper {

    public PersonMapper() {

    }

    public static Person toEntity(PersonDTO personDTO) {
        return Person.builder()
                .id(Optional.ofNullable(personDTO.id()).orElse(UUID.randomUUID()))
                .name(personDTO.name())
                .age(personDTO.age())
                .address(personDTO.address())
                .institutions(personDTO.institutions())
                .rollNumber(personDTO.rollNumber())
                .email(personDTO.email())
                .build();
    }

    public static PersonDTO toDto(Person person) {
        return PersonDTO.builder()
                .id(person.getId())
                .name(person.getName())
                .age(person.getAge())
                .address(person.getAddress())
                .institutions(person.getInstitutions())
                .rollNumber(person.getRollNumber())
                .email(person.getEmail())
                .build();
    }
public static List<PersonDTO> toDtoList(Iterable<Person> persons){
        List<PersonDTO> dtoList = new ArrayList<>();
        persons.forEach(entity -> dtoList.add(toDto(entity)));
        return dtoList;
}
}
