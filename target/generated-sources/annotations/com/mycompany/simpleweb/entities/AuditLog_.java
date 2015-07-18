package com.mycompany.simpleweb.entities;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-07-17T17:55:00")
@StaticMetamodel(AuditLog.class)
public class AuditLog_ { 

    public static volatile SingularAttribute<AuditLog, Integer> id;
    public static volatile SingularAttribute<AuditLog, Timestamp> timestamp;
    public static volatile SingularAttribute<AuditLog, String> account;

}