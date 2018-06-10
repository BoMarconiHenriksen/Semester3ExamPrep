package entities;

import entities.Pet;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.4.v20160829-rNA", date="2018-06-05T09:46:12")
@StaticMetamodel(Event.class)
public class Event_ { 

    public static volatile SingularAttribute<Event, Date> date;
    public static volatile SingularAttribute<Event, Pet> petId;
    public static volatile SingularAttribute<Event, String> remark;
    public static volatile SingularAttribute<Event, Integer> id;
    public static volatile SingularAttribute<Event, String> event;

}