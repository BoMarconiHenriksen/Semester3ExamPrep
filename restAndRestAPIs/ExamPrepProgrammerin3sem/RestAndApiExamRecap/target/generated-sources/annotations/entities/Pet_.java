package entities;

import entities.Event;
import entities.Owner;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20160829-rNA", date="2018-06-05T09:46:12")
@StaticMetamodel(Pet.class)
public class Pet_ { 

    public static volatile ListAttribute<Pet, Event> eventList;
    public static volatile SingularAttribute<Pet, Date> death;
    public static volatile SingularAttribute<Pet, String> species;
    public static volatile SingularAttribute<Pet, String> name;
    public static volatile SingularAttribute<Pet, Date> birth;
    public static volatile SingularAttribute<Pet, Integer> id;
    public static volatile SingularAttribute<Pet, Owner> ownerId;

}