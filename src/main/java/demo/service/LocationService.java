package demo.service;

import demo.domain.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LocationService {
    List<Location> saveRunningLocation(List<Location> runningLocations);

    void deleteAll();

    Page<Location> findByRunnerMovementType(String movementType, Pageable pageable);
}
