/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.simpleweb.service;

import com.mycompany.simpleweb.entities.AuditLog;
import javax.ejb.EJB;
import junit.framework.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.ByteArrayAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author Bkahlon
 */
@RunWith(Arquillian.class)
public class AuditLogServiceTest {

    @Deployment
    public static JavaArchive createTestArchive() {
        return ShrinkWrap.create(JavaArchive.class, "test.jar").addPackage(AuditLog.class.getPackage()).addPackage(AuditLogService.class.getPackage()).addAsManifestResource(
                new ByteArrayAsset("<beans>".getBytes()),
                ArchivePaths.create("beans.xml")).addAsManifestResource(
                        "test-persistence.xml",
                        ArchivePaths.create("persistence.xml"));
    }

    @EJB
    AuditLogService service;

    @Test
    public void insertLog() throws Exception {
        service.writeLog("Markus");
        int numberOfLogs = service.findAllLogs();
        Assert.assertEquals(1, numberOfLogs);

    }
}
