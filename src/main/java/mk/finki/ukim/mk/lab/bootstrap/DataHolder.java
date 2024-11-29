package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.repository.EventRepo;
import mk.finki.ukim.mk.lab.repository.LocationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {
    public static List<Event>events=new ArrayList<>();
    public static List<Location>locations=new ArrayList<>();
    @Autowired
    private LocationRepo locationRepository;

    @Autowired
    private EventRepo eventRepository;
    @PostConstruct
    public void init() {

        if (locationRepository.count() == 0) {
            locations.add(new Location("Toshe Proeski Stadion", "Skopje", "30,000", "Glaven sportski stadion"));
            locations.add(new Location("Teatar Komedija", "Centar, Skopje", "500", "Teatar za pretstavi - komedija"));
            locations.add(new Location("Sala Boris Trajkovski", "Karposh, Skopje", "2000", "Sala za koncerti"));
            locations.add(new Location("Bar Fire", "Karposh, Skopje", "100", "Coctail Bar"));
            locations.add(new Location("Nacionalen Park - Mavrovo", "Mavrovo, Makedonija", "Otvoren prostor", "Priroda"));


            for (Location location : locations) {
                locationRepository.save(location);
            }
        } else {

            locations = locationRepository.findAll();
        }


        if (eventRepository.count() == 0) {
            events.add(new Event("Fudbalski natprevar", "MKD vs Latvia", 9.0, locations.get(0)));
            events.add(new Event("Stand up show", "STAND UP COMEDY - MARJAN GJORGJIEVSKI", 8.0, locations.get(1)));
            events.add(new Event("Koncert", "Kaliopi - Koncert", 9.0, locations.get(2)));
            events.add(new Event("Teatarska pretstava", "Vardarski Pastuvi - Teatarska pretstava", 9.0, locations.get(1)));
            events.add(new Event("Maraton", "Wizz Air Maraton Skopje", 8.0, locations.get(0)));
            events.add(new Event("Film Premiera", "'Here' - Tom Hanks, Robin Wright ", 7.0, locations.get(1)));
            events.add(new Event("Svecheno otvaranje na bar", "Bar Fire - Skopje", 6.0, locations.get(3)));
            events.add(new Event("Halloween Skopje 2024", "Proslava na Halloween", 8.0, locations.get(2)));
            events.add(new Event("Skopje Wine Festival", "Festival na vinoto - Vinoskop", 7.0, locations.get(0)));
            events.add(new Event("Koncert", "Marija Sherifovikj - Koncert", 7.0, locations.get(2)));


            for (Event event : events) {
                eventRepository.save(event);
            }
        } else {

            events = eventRepository.findAll();
        }
    }
}
