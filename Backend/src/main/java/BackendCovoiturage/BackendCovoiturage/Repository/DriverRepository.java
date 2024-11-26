package BackendCovoiturage.BackendCovoiturage.Repository;

import BackendCovoiturage.BackendCovoiturage.Entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    // Custom query methods can be added if needed
}
