/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import static entities.PetFacade.events;
import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Bo
 */
public class EventFacade {
    //dyr
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("dyr");
    EntityManager em = emf.createEntityManager();
    //PetFacade pf = new PetFacade();
    
    public static HashMap<Integer, Event> eventHash = new HashMap<>();

    public List<Event> getAllEvents() {
        List<Event> events;
        Query q = em.createQuery("select e.id, e.event, e.remark, e.petId.id from Event e");

        events = q.getResultList();

        return events;
    }

    public Event findEventById(int id) {
        Event event = getAllEvents().get(id);
        return event;
    }

    public List<Event> getAllEventsByPetId(Integer petId) {

        List<Event> events;
        Query q = em.createQuery("select e from Event e where e.petId=:petId");
        q.setParameter("petId", petId);

        events = q.getResultList();
        for (Integer i = 0; i < events.size(); i++) {
            eventHash.put(i, events.get(i));
        }
        return events;

    }

    public static Event findEventByEventId(Integer id) {
        return eventHash.get(id);
    }
}
