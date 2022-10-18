package micronaut_crud_rest.endpoint;

import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import micronaut_crud_rest.dto.PersonDTO;
import micronaut_crud_rest.mapper.PersonMapper;
import micronaut_crud_rest.services.PersonServices;

import java.util.List;
import java.util.UUID;

@Controller("/person")
public class PersonController {
    @Inject
    PersonServices personServices;

    @Post("/createPerson")
    public PersonDTO createPerson(@Body PersonDTO body){
        var data = personServices.createPerson(body);
        return data;
    }

    @Get("/getPerson")
    public List<PersonDTO> getAllUsers(){
        return personServices.getAllUsers();
    }

    @Get(value = "/{name}")
    public List<PersonDTO> personByName(@PathVariable String name){
        return personServices.getByName(name);
    }

//    @Get(value = "/{age}")
//    public List<PersonDTO> personByAge(@PathVariable String age){
//        return personServices.getByAge(age);
//    }

    @Delete(value = "/{id}")
    public boolean deleteById(@PathVariable UUID id){
        return personServices.deleteById(id);
    }

    @Put("/updatePerson")
    public PersonDTO updatePerson(@Body PersonDTO body){
        var a = personServices.findById(body.id());
        return personServices.updateName(body.id(), body);
    }


}
