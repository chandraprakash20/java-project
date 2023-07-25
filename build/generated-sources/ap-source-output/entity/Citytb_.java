package entity;

import entity.Sellertb;
import entity.Statetb;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-06-21T12:43:29", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Citytb.class)
public class Citytb_ { 

    public static volatile SingularAttribute<Citytb, String> city;
    public static volatile SingularAttribute<Citytb, Date> lastUpdate;
    public static volatile SingularAttribute<Citytb, Statetb> stateId;
    public static volatile CollectionAttribute<Citytb, Sellertb> sellertbCollection;
    public static volatile SingularAttribute<Citytb, Integer> cityId;
    public static volatile SingularAttribute<Citytb, Integer> isActive;
    public static volatile SingularAttribute<Citytb, Date> createDate;

}