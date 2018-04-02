package com.memberdemo.member.api;

import com.memberdemo.member.application.PersistenceHelper;
import com.memberdemo.member.entity.Member;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("/member")
public class MemberAPI {

    @Inject
    PersistenceHelper persistenceHelper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        TypedQuery<Member> query = persistenceHelper.getEntityManager().createNamedQuery(Member.FIND_ALL, Member.class);
        Collection<Member> allMembers = query.getResultList();
        return Response.ok(allMembers).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(final @PathParam("id")Long id) {
        Member member = persistenceHelper.getEntityManager().find(Member.class, id);
        return Response.ok(member).build();
    }
}
