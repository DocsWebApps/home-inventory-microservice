package com.docswebapps.homeinventoryservice.bootstrap;
import com.docswebapps.homeinventoryservice.domain.Location;
import com.docswebapps.homeinventoryservice.repository.LocationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LocationBaseDataInsert implements CommandLineRunner {
    private final LocationRepository locationRepository;

    public LocationBaseDataInsert(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(locationRepository.count() == 0) {
            locationRepository.save(Location.builder().name("Living Room").build());
            locationRepository.save(Location.builder().name("Garage").build());
            locationRepository.save(Location.builder().name("Shed").build());
            locationRepository.save(Location.builder().name("Dining Room").build());
            locationRepository.save(Location.builder().name("Test").build());
        }
    }
}
