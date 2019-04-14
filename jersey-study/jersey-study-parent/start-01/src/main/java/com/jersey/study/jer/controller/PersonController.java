package com.jersey.study.jer.controller;

import com.jersey.study.jer.dto.Person;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;

/**
 * Created by query on 2017/11/13.
 */
@Path("/person")
public class PersonController {
    @GET
    @Path("/xml/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Person getXML(@PathParam("id") Long id){
        Person person = new Person();
        person.setAge(22);
        person.setName("kevin");
        return person;
    }

    @GET
    @Path("/json/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getJSON(@PathParam("id") Long id){
        Person person = new Person();
        person.setAge(22);
        person.setName("kevin");
        return person;
    }

    @GET
    @Path("/getList")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getList(@MatrixParam("name") List<String> name) {
        List<Person> personList = new ArrayList<Person>();
        for(String n : name) {
            Person p = new Person();
            p.setAge(1);
            p.setName(n);
            personList.add(p);
        }
        return personList;
    }

    @GET
    @Path("/getSet")
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Person> getSet(@MatrixParam("name") List<String> name) {
        Set<Person> personSet = new HashSet<Person>();
        for(String n : name) {
            Person p = new Person();
            p.setAge(1);
            p.setName(n);
            personSet.add(p);
        }
        return personSet;
    }

    @GET
    @Path("/getMap")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Person> getMap(@MatrixParam("name") List<String> name) {
        Map<String, Person> map = new HashMap<String, Person>();
        for(String n : name) {
            Person p = new Person();
            p.setAge(1);
            p.setName(n);
            map.put(n, p);
        }
        return map;
    }
}
