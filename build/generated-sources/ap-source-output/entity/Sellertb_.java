package entity;

import entity.Citytb;
import entity.Propertytb;
import entity.Statetb;
import entity.Usertb;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-06-21T12:43:29", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Sellertb.class)
public class Sellertb_ { 

    public static volatile SingularAttribute<Sellertb, String> address;
    public static volatile SingularAttribute<Sellertb, String> companyName;
    public static volatile SingularAttribute<Sellertb, Statetb> stateId;
    public static volatile SingularAttribute<Sellertb, String> companyURL;
    public static volatile SingularAttribute<Sellertb, Citytb> cityId;
    public static volatile SingularAttribute<Sellertb, String> type;
    public static volatile SingularAttribute<Sellertb, Integer> isActive;
    public static volatile SingularAttribute<Sellertb, Usertb> userId;
    public static volatile SingularAttribute<Sellertb, Integer> sellerId;
    public static volatile SingularAttribute<Sellertb, String> updateBy;
    public static volatile SingularAttribute<Sellertb, Date> lastUpdate;
    public static volatile SingularAttribute<Sellertb, Propertytb> propertyId;
    public static volatile SingularAttribute<Sellertb, Date> createDate;

}