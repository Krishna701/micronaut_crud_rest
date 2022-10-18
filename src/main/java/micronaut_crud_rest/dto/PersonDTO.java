package micronaut_crud_rest.dto;


import io.micronaut.core.annotation.Introspected;
import lombok.Builder;

import java.util.UUID;

@Introspected
public record PersonDTO(UUID id,
                        String name,
                        String age,
                        String address,
                        String institutions,
                        String rollNumber,
                        String email) {
    @Builder(toBuilder = true)
    public PersonDTO {

    }
}
