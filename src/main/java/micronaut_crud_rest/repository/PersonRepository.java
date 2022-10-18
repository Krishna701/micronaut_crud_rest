package micronaut_crud_rest.repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;
import io.micronaut.data.repository.CrudRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import micronaut_crud_rest.Entity.Person;
import micronaut_crud_rest.dto.PersonDTO;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PersonRepository extends CrudRepository<Person, UUID> {
//    @Override
//    Optional<Person> findById(@NotNull UUID uuid);
    List<Person> findByName(String name);

    List<Person> findByAge(String age);

//    List<Person>findByNameIs(String name);

//    List<Person> findByNameEquals(String name);
}
