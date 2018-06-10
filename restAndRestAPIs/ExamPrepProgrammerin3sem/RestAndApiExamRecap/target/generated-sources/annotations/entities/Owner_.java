package entities;

import entities.Pet;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20160829-rNA", date="2018-06-05T09:46:12")
@StaticMetamodel(Owner.class)
public class Owner_ { 

    public static volatile SingularAttribute<Owner, String> firstName;
    public static volatile SingularAttribute<Owner, String> lastName;
    public static volatile SingularAttribute<Owner, String> address;
    public static volatile ListAttribute<Owner, Pet> petList;
    public static volatile SingularAttribute<Owner, Integer> id;

}