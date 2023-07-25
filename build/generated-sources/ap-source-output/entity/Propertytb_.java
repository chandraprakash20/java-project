package entity;

import entity.Propertyamenitiestb;
import entity.Propertyfeaturestb;
import entity.Propertyimagetb;
import entity.Propertytypetb;
import entity.Sellertb;
import entity.Wishlisttb;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-06-21T12:43:29", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Propertytb.class)
public class Propertytb_ { 

    public static volatile SingularAttribute<Propertytb, String> areaUnit;
    public static volatile CollectionAttribute<Propertytb, Propertyamenitiestb> propertyamenitiestbCollection;
    public static volatile CollectionAttribute<Propertytb, Propertyimagetb> propertyimagetbCollection;
    public static volatile SingularAttribute<Propertytb, String> description;
    public static volatile SingularAttribute<Propertytb, Integer> isActive;
    public static volatile SingularAttribute<Propertytb, Propertytypetb> propertyTypeId;
    public static volatile CollectionAttribute<Propertytb, Wishlisttb> wishlisttbCollection;
    public static volatile SingularAttribute<Propertytb, String> propertyName;
    public static volatile SingularAttribute<Propertytb, String> price;
    public static volatile SingularAttribute<Propertytb, Date> lastUpdate;
    public static volatile CollectionAttribute<Propertytb, Sellertb> sellertbCollection;
    public static volatile SingularAttribute<Propertytb, Integer> propertyId;
    public static volatile CollectionAttribute<Propertytb, Propertyfeaturestb> propertyfeaturestbCollection;
    public static volatile SingularAttribute<Propertytb, String> plotArea;
    public static volatile SingularAttribute<Propertytb, Date> createDate;

}