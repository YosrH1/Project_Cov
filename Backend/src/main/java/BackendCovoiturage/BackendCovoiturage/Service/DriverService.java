package BackendCovoiturage.BackendCovoiturage.Service;

import BackendCovoiturage.BackendCovoiturage.Entity.Driver;
import BackendCovoiturage.BackendCovoiturage.Repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    // Add a new driver
    public Driver addDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    // Get all drivers
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    // Get driver by ID
    public Optional<Driver> getDriverById(Long id) {
        return driverRepository.findById(id);
    }
    public void deleteDriver(Long driverId) {
        Optional<Driver> driver = driverRepository.findById(driverId);
        if (driver.isPresent()) {
            driverRepository.delete(driver.get());
        } else {
            throw new IllegalArgumentException("Driver not found.");
        }
    }

}
