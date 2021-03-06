package com.docswebapps.homeinventoryservice.bootstrap;
import com.docswebapps.homeinventoryservice.domain.Location;
import com.docswebapps.homeinventoryservice.repository.LocationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("locationBaseDataInsert")
@Order(2)
public class LocationBaseDataInsert implements CommandLineRunner {
    private final LocationRepository locationRepository;

    public LocationBaseDataInsert(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (locationRepository.count() == 0) {
            locationRepository.save(Location.builder().name("LIVING ROOM").build());
            locationRepository.save(Location.builder().name("GARAGE").build());
            locationRepository.save(Location.builder().name("SHED").build());
            locationRepository.save(Location.builder().name("DINING ROOM").build());
        }
    }
}
