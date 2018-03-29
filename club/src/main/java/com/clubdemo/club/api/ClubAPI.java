package com.clubdemo.club.api;

import com.clubdemo.club.application.PersistenceHelper;
import com.clubdemo.club.entity.Club;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("/club")
public class ClubAPI {

    @Inject
    PersistenceHelper persistenceHelper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        TypedQuery<Club> query = persistenceHelper.getEntityManager().createNamedQuery(Club.FIND_ALL, Club.class);
        Collection<Club> allClubs = query.getResultList();
        return Response.ok(allClubs).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(final @PathParam("id")Long id) {
        Club club = persistenceHelper.getEntityManager().find(Club.class, id);
        return Response.ok(club).build();
    }
}
