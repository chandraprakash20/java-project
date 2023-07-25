package entity;

import entity.Grouptb;
import entity.Usertb;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-06-21T12:43:29", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Usergrouptb.class)
public class Usergrouptb_ { 

    public static volatile SingularAttribute<Usergrouptb, Integer> userGroupId;
    public static volatile SingularAttribute<Usergrouptb, Date> lastUpdate;
    public static volatile SingularAttribute<Usergrouptb, Grouptb> groupId;
    public static volatile SingularAttribute<Usergrouptb, Integer> isActive;
    public static volatile SingularAttribute<Usergrouptb, Usertb> userId;
    public static volatile SingularAttribute<Usergrouptb, Date> createDate;

}