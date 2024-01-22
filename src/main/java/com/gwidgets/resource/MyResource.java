package com.gwidgets.resource;

import com.gwidgets.dto.ApiResponse;
import com.gwidgets.model.User;
import com.gwidgets.service.SimpleService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/resource")
public class MyResource {

    @Inject
    SimpleService simpleService;

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getIt(@PathParam("name") String name) {
        return simpleService.getUser(name);
    }

    @POST
    @Path("/newUser")
    @Produces(MediaType.APPLICATION_JSON)
    public ApiResponse addUser(User user) {
        System.out.println("user " + user);
        return simpleService.saveUser(user);
    }

    @GET
    @Path("/getUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public ApiResponse getAllUsers() {
        return simpleService.getAllUsers();
    }
}