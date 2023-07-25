package entity;

import entity.Propertytb;
import entity.Usertb;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-06-21T12:43:29", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Wishlisttb.class)
public class Wishlisttb_ { 

    public static volatile SingularAttribute<Wishlisttb, Date> lastUpdate;
    public static volatile SingularAttribute<Wishlisttb, Integer> isActive;
    public static volatile SingularAttribute<Wishlisttb, Integer> wishlistId;
    public static volatile SingularAttribute<Wishlisttb, Usertb> userId;
    public static volatile SingularAttribute<Wishlisttb, Propertytb> propertyId;
    public static volatile SingularAttribute<Wishlisttb, Date> createDate;

}