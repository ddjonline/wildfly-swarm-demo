package com.clubdemo.club.application;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class PersistenceHelper {

    @PersistenceContext(unitName = "clubPU")
    private EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }
}
