package entities.messages;

import entities.Event;
import entities.EventFacade;
import entities.Owner;
import entities.Pet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author bladt
 */
public class PetMessage implements JSONMessage<Pet> {

    public Integer id;
    public String name;
    public Date birth;
    public String species;
    public Date death;
    public Owner ownerId;
    public List<Integer> eventIds;

    public PetMessage(Pet pet) {
        this.name = pet.getName();
        this.birth = pet.getBirth();
        this.death = pet.getDeath();
        this.species = pet.getSpecies();

        //Get pets ids as list.
        Stream<Event> eventEntities = pet.getEventList().stream();
        Stream<Integer> eventIds = eventEntities.map(c -> c.id);
        this.eventIds = eventIds.collect(Collectors.toList());
    }

    @Override
    public Pet toInternal() {
        ArrayList<Event> events = new ArrayList<>();
        EventFacade eventFacade = new EventFacade();
        
        eventIds.forEach((id) -> {
            events.add(eventFacade.findEventById(id));
        });
        return new Pet(name, birth, species, death, id, ownerId, events);
    }

}
