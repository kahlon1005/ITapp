/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.simpleweb.service;

import com.mycompany.simpleweb.entities.AuditLog;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Bkahlon
 */
@Stateless
public class AuditLogService {

    @PersistenceContext
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public void writeLog(String account) {
        AuditLog log = new AuditLog();
        log.setAccount(account);
        em.persist(log);
    }

    public int findAllLogs() {
        TypedQuery<AuditLog> query = em.createNamedQuery("AuditLog.findAllAuditLogs", AuditLog.class);
        return query.getResultList().size();

    }

}
