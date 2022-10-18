package micronaut_crud_rest.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "person_info")
public class Person {
    @Id
    private UUID id;

    @Column
    private String name;

    @Column
    private String age;

    @Column
    private String address;

    @Column
    private String institutions;

    @Column(name = "roll_number", unique = true)
    private String rollNumber;

    @Column
    private String email;

}
