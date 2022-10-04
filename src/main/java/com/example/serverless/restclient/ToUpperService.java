package com.example.serverless.restclient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

@Path("/")
@RegisterRestClient
public interface ToUpperService {

    @GET
    @Path("/toupper")
    @Produces(MediaType.TEXT_PLAIN)
    String toUpper(@QueryParam String input);
}