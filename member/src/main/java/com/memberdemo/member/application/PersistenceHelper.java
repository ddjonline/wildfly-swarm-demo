package com.memberdemo.member.application;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class PersistenceHelper {

    @PersistenceContext(unitName = "memberPU")
    private EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }
}
