package ch.zli.m223.service;

import io.smallrye.jwt.build.Jwt;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Arrays;
import java.util.HashSet;

@Path("/auth") 
public class AuthService {

    @POST
    @Path("/token") 
    @Produces(MediaType.TEXT_PLAIN)
    public Response generateToken() {
        try {
            String token = Jwt
                    .upn("jdoe@quarkus.io")
                    .issuer("https://example.com/issuer")
                    .groups(new HashSet<>(Arrays.asList("User", "Admin")))
                    .sign();

            return Response.ok(token).build();

        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
