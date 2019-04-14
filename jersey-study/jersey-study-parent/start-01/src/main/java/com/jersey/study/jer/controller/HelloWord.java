package com.jersey.study.jer.controller;

import org.springframework.stereotype.Component;

import javax.ws.rs.*;


@Component
@Path("/")
public class HelloWord {

    @GET
    @Path("hello")
    @Produces("text/plain")
    public String hello(){
        return "Hello World ";
    }


    @GET
    @Path("hello/{username}")
    @Produces("text/plain")
    public String hello2(@PathParam("username") String username){
        return "hi~ "+username;
    }

    @GET
    @Path("qp")
    public String hello3(@DefaultValue("isDefault") @QueryParam("a1") String a1){
        return "write "+a1;
    }

}
