package BackendCovoiturage.BackendCovoiturage.Repository;

import BackendCovoiturage.BackendCovoiturage.Entity.Carpool;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarpoolRepository extends JpaRepository<Carpool, Long> {
}
