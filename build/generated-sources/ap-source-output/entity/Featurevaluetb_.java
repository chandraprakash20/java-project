package entity;

import entity.Featurestb;
import entity.Propertyfeaturestb;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-06-21T12:43:29", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Featurevaluetb.class)
public class Featurevaluetb_ { 

    public static volatile SingularAttribute<Featurevaluetb, Integer> featureValueId;
    public static volatile SingularAttribute<Featurevaluetb, Integer> lastUpdate;
    public static volatile SingularAttribute<Featurevaluetb, Integer> isActive;
    public static volatile SingularAttribute<Featurevaluetb, String> value;
    public static volatile CollectionAttribute<Featurevaluetb, Propertyfeaturestb> propertyfeaturestbCollection;
    public static volatile SingularAttribute<Featurevaluetb, Integer> featureId;
    public static volatile SingularAttribute<Featurevaluetb, Integer> createDate;
    public static volatile SingularAttribute<Featurevaluetb, Featurestb> featurestb;

}