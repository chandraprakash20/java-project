package entity;

import entity.Featurestb;
import entity.Featurevaluetb;
import entity.Propertytb;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-06-21T12:43:29", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Propertyfeaturestb.class)
public class Propertyfeaturestb_ { 

    public static volatile SingularAttribute<Propertyfeaturestb, Featurevaluetb> featureValueId;
    public static volatile SingularAttribute<Propertyfeaturestb, Date> lastUpdate;
    public static volatile SingularAttribute<Propertyfeaturestb, Integer> propertyFeatureId;
    public static volatile SingularAttribute<Propertyfeaturestb, Integer> isActive;
    public static volatile SingularAttribute<Propertyfeaturestb, Propertytb> propertyId;
    public static volatile SingularAttribute<Propertyfeaturestb, Featurestb> featureId;
    public static volatile SingularAttribute<Propertyfeaturestb, Date> createDate;

}