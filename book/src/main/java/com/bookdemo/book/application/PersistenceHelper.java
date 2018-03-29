package com.bookdemo.book.application;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class PersistenceHelper {

    @PersistenceContext(unitName = "bookPU")
    private EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }
}
