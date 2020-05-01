package demo.service.impl;

import demo.domain.Location;
import demo.domain.LocationRepostory;
import demo.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {
    private LocationRepostory locationRepostory;

    @Autowired
    public  LocationServiceImpl(LocationRepostory locationRepostory) {
        this.locationRepostory = locationRepostory;
    }

    @Override
    public List<Location> saveRunningLocation(List<Location> runningLocations) {
        return locationRepostory.save(runningLocations);
    }

    @Override
    public void deleteAll() {
        locationRepostory.deleteAll();
    }

    @Override
    public Page<Location> findByRunnerMovementType(String movementType, Pageable pageable) {
        return locationRepostory.findByRunnerMovementType(Location.RunnerMovementType.valueOf(movementType), pageable);
    }
}
