package com.myr.resources;


import com.myr.model.Person;
import com.myr.service.PersonService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
public class PersonResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String test(){
        return "Hi Working";
    }

    @Path("/persons")
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Person> fetchAllPerson(){
        PersonService personService=new PersonService();
        return personService.fetchAllPerson();
    }
}
