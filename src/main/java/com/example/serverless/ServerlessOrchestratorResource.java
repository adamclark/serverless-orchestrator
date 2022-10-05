package com.example.serverless;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.serverless.restclient.ToUpperService;

@Path("/toupper")
public class ServerlessOrchestratorResource {

    private static final Logger logger = LoggerFactory.getLogger(ServerlessOrchestratorResource.class);

    @Inject
    @RestClient
    ToUpperService toUpperService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String runToUpperJobs(@QueryParam("input") String input) {

        StringBuffer output = new StringBuffer();

        for (char ch: input.toCharArray()) {

            String upperChar = toUpperService.toUpper(Character.toString(ch));
        
            logger.info(upperChar.toString());
            
            // Collate job output
            output.append(upperChar);
        }

        logger.info(output.toString());

        return output.toString();
    }
}