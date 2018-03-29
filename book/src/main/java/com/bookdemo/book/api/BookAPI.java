package com.bookdemo.book.api;

import com.bookdemo.book.application.PersistenceHelper;
import com.bookdemo.book.entity.Book;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("/book")
public class BookAPI {

    @Inject
    PersistenceHelper persistenceHelper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        TypedQuery<Book> query = persistenceHelper.getEntityManager().createNamedQuery(Book.FIND_ALL, Book.class);
        Collection<Book> allBooks = query.getResultList();
        return Response.ok(allBooks).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(final @PathParam("id")Long id) {
        Book book = persistenceHelper.getEntityManager().find(Book.class, id);
        return Response.ok(book).build();
    }
}
