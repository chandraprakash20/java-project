package entity;

import entity.Sellertb;
import entity.Usergrouptb;
import entity.Wishlisttb;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-06-21T12:43:29", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Usertb.class)
public class Usertb_ { 

    public static volatile SingularAttribute<Usertb, String> password;
    public static volatile CollectionAttribute<Usertb, Wishlisttb> wishlisttbCollection;
    public static volatile SingularAttribute<Usertb, Integer> isSeller;
    public static volatile SingularAttribute<Usertb, Date> lastUpdate;
    public static volatile CollectionAttribute<Usertb, Sellertb> sellertbCollection;
    public static volatile SingularAttribute<Usertb, String> mobileNo;
    public static volatile SingularAttribute<Usertb, String> userName;
    public static volatile SingularAttribute<Usertb, Integer> isActive;
    public static volatile SingularAttribute<Usertb, Integer> userId;
    public static volatile CollectionAttribute<Usertb, Usergrouptb> usergrouptbCollection;
    public static volatile SingularAttribute<Usertb, String> email;
    public static volatile SingularAttribute<Usertb, Date> createDate;

}